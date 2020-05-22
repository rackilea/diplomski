public final class MyScreen extends MainScreen
{
    boolean val=false;
    private BrowserField contentField;
    public MyScreen() {

        final ButtonField l=new ButtonField("menu");

        final HorizontalFieldManager hfm_main=new HorizontalFieldManager();

        final VerticalFieldManager vfm_l=new VerticalFieldManager(){
             protected void sublayout(int maxWidth, int maxHeight) {
                    super.sublayout(280, maxHeight);
                    setExtent(280, maxHeight);
                }
             protected void paint(Graphics g){
                    g.setBackgroundColor(Color.RED);
                    g.clear();
                    super.paint(g);
                }
        };
        final VerticalFieldManager vfm_r=new VerticalFieldManager(){
             protected void sublayout(int maxWidth, int maxHeight) {
                 int ourRequiredWidth = Display.getWidth();
                 super.sublayout(ourRequiredWidth, maxHeight);
                 setExtent(ourRequiredWidth, maxHeight);
             }
             protected void paint(Graphics g){
                 g.setBackgroundColor(Color.YELLOW);
                 g.clear();
                 super.paint(g);
             }
        };

        vfm_l.add(new LabelField("sliding pannel"));

        vfm_r.add(l);

        BrowserField bf = new BrowserField();
        vfm_r.add(bf);
        bf.requestContent("http://www.google.com");

        hfm_main.add(vfm_r);

        add(hfm_main);

        FieldChangeListener listener=new FieldChangeListener() {
            public void fieldChanged(Field field, int context) {
                if(field==l){
                    if(vfm_l.getManager() == null){
                        hfm_main.insert(vfm_l, 0);
                    } else {
                        hfm_main.delete(vfm_l);
                    }
                }
            }
        };

        l.setChangeListener(listener);
    }

}