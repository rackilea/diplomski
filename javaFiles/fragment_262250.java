@SuppressLint("SetJavaScriptEnabled")
public class GeoChartActivity extends Activity {


    String url = "https://battery-75d95.firebaseio.com/";

    WebView webView;
    int num1, num2;
    public static  List<GeoTotalByCountry> lstItemArry;
    List listOfStudent;

    public static List<Order> salArry;
    public static List<Order> hosArry;
    public static List<Order> ProductData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geo_chart);

        ProductData = new ArrayList<>();
        hosArry = new ArrayList();
        salArry = new ArrayList();
        lstItemArry = new ArrayList();

        listOfStudent = new ArrayList();



        getOrderArray();


        num1 = 390;

        webView = (WebView)findViewById(R.id.web);


        webView.addJavascriptInterface(new WebAppInterface(), "Android");


        webView.getSettings().setJavaScriptEnabled(true);
        // webView.loadUrl("file:///android_asset/chart.html");

        webView.loadUrl("file:///android_asset/geochart.html");

        //WebView web = new WebView(this);
        webView.setPadding(0, 0, 0, 0);



    }








    public class WebAppInterface {

        @JavascriptInterface
        public String getArrayGeoChartData() {
//            System.out.println(listOfStudent.toString());
            return String.valueOf(listOfStudent);
        }

        @JavascriptInterface
        public int getNum1() {
            return num1;
        }


    }








    //arrayOrder
    void getOrderArray() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitArrayAPI service = retrofit.create(RetrofitArrayAPI.class);

        Call<List<Order>> call = service.getOrderDetails();

        call.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Response<List<Order>> response, Retrofit retrofit) {

                try {
                    ProductData = response.body();
                    for (int i = 0; i < ProductData.size(); i++) {

                        //displaying the string array into gridView

                        Order b = new Order();
                        b.setId(ProductData.get(i).getId());
                        b.setStatus(ProductData.get(i).getStatus());
                        b.setTotal(ProductData.get(i).getTotal());
                        b.setBilling(ProductData.get(i).getBilling());
                        hosArry.add(b);

                    }

                    listOfStudent = new ArrayList<>();


                    //   Log.v("hosarry", String.valueOf(hosArry.size()));
                    for (int i =0; i<hosArry.size(); i++){

                      //  if(hosArry.get(i).getStatus().contains("completed"))
                        {
                            GeoTotalByCountry b = new GeoTotalByCountry();
                            b.setId(hosArry.get(i).getId());
                            b.setTotal(hosArry.get(i).getTotal());
                            b.setCountry(hosArry.get(i).getBilling().getCountry());
                            lstItemArry.add(b);
                        }
                    }
                 //   Log.v("listOfStudent", String.valueOf(salArry.size()));



             Map<String, List<GeoTotalByCountry>> map = new HashMap<String, List<GeoTotalByCountry>>();

                    for (GeoTotalByCountry student : lstItemArry) {
                        String key  = String.valueOf(student.getCountry());
                        if(map.containsKey(key)){
                            List<GeoTotalByCountry> list = map.get(key);
                            list.add(student);

                        }else{
                            List<GeoTotalByCountry> list = new ArrayList<GeoTotalByCountry>();
                            list.add(student);
                            map.put(key, list);
                        }

                    }


                    System.out.println("map"+map);


                    //Summing for Net Quentity

                    for (Map.Entry<String, List<GeoTotalByCountry>> entry : map.entrySet()) {
                        //  System.out.println("Key : " + entry.getKey() + " value : " + entry.getValue());

                        // for (int i=0 ; i< entry.getKey().length(); i++){
                        Double sum = 0.00, value;
                        for (int j = 0; j < entry.getValue().size(); j++){
                            value = Double.valueOf(String.valueOf(entry.getValue().get(j)));
                            //System.out.println(j+ "value = " + value);
                            sum += value;

                            //  System.out.println(j+"chgevalue = " + sum);
                        }
                        System.out.println("chgevalue = " + sum.intValue());

                        // System.out.println( "Key : " + entry.getKey() + "qty = " + sum);
                        //System.out.println(getProductById(Integer.valueOf(entry.getKey())));

                        ChartGeoModel pieDataXYChart = new ChartGeoModel();

                        pieDataXYChart.setCountry(entry.getKey());
                        pieDataXYChart.setTotal(sum.intValue());
                        listOfStudent.add(pieDataXYChart);
                    }

                    System.out.println(listOfStudent.toString());




                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });
    }
}