public class MyMathView extends WebView {
    private String TAG = "KhanAcademyKatexView";
    private static final float default_text_size = 18;
    private String display_text;
    private int text_color;
    private int text_size;
    private boolean clickable = false;

    private boolean loaded = false;
    private int loadedPercentage = 0;

    public MyMathView(Context context) {
        //...
    }

    public MyMathView(Context context, AttributeSet attrs) {
        //...
    }

    public boolean isLoaded(){
        return loaded;
    }

    public int getLoadedPercentage() {
        return loadedPercentage;
    }

    public void setViewBackgroundColor(int color)
    {
        //...
    }

    private void pixelSizeConversion(float dimension) {
        //...
    }

    private void configurationSettingWebView()
    {
        //...
    }


    public void setDisplayText(String formula_text) {
        this.display_text = formula_text;
        loadData();
    }

   private String getOfflineKatexConfig()
    {
        String offline_config = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <title>Auto-render test</title>\n" +
                "        <link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/katex/katex.min.css\">\n" +
                "        <link rel=\"stylesheet\" type=\"text/css\" href=\"file:///android_asset/themes/style.css\">\n" +
                "        <script type=\"text/javascript\" src=\"file:///android_asset/katex/katex.min.js\"></script>\n" +
                "        <script type=\"text/javascript\" src=\"file:///android_asset/katex/contrib/auto-render.min.js\"></script>\n" +
                " <style type='text/css'>"+
                "body {"+
                "margin: 0px;"+
                "padding: 0px;"+
                "font-size:" +this.text_size+"px;"+
                "color:"+getHexColor(this.text_color)+";"+
                " }"+
                " </style>"+
                "    </head>\n" +
                "    <body>\n" +
                "        {formula}\n" +
                "        <script>\n" +
                "          renderMathInElement(\n" +
                "              document.body\n" +
                "          );\n" +
                "        </script>\n" +
                "    </body>\n" +
                "</html>";
        String start = "<html><head><meta http-equiv='Content-Type' content='text/html' charset='UTF-8' /><style> body {"+
       " white-space: nowrap;}</style></head><body>";

        String end = "</body></html>";

        //return   start+offline_config.replace("{formula}",this.display_text)+end;
        return offline_config.replace("{formula}",this.display_text);

    }


    private void loadData()
    {
        if (this.display_text!=null)
        {
            loadedPercentage = 0;
            loaded = false;

            this.setWebChromeClient(new WebChromeClient(){
                public void onProgressChanged(WebView view, int newProgress) {
                    super.onProgressChanged(view, newProgress);
                    loadedPercentage = newProgress;
                    if(newProgress==100) {
                        loaded = true;
                        Toast.makeText(getContext(), newProgress + "LOADED", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            this.loadDataWithBaseURL("null",getOfflineKatexConfig(),"text/html","UTF-8","about:blank");
        }
    }


    public void setTextSize(int size)
    {
       //...
    }
    public void setTextColor(int color)
    {
       //...
    }
    private String getHexColor(int intColor)
    {
       //...
    }


    private void setDefaultTextColor(Context context) {
       //...
    }

    private void setDefaultTextSize() {
        //...
    }

}