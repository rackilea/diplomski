public class home extends AppCompatActivity {

  //a list to store all the products
    List<Product> productList;
    //the recyclerview
    RecyclerView recyclerView;
    adepter a;
    ProgressBar Pbar;
    GridLayoutManager manager;
    int token = 1;
  Boolean isScrolling = false;
    int currentItems, totalItems, scrollOutItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Pbar = findViewById(R.id.progressBar1);
        //getting the recyclerview from xml
        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
         manager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(manager);

        //initializing the productlist
        productList = new ArrayList<>();


 a = new adepter(home.this, productList);
                recyclerView.setAdapter(a);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                {
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItems = manager.getChildCount();
                totalItems = manager.getItemCount();
                scrollOutItems = manager.findFirstVisibleItemPosition();

                if(isScrolling && (currentItems + scrollOutItems == totalItems))
                {
                    isScrolling = false;
                    token++;
                    getData();
                }
            }
        });
        getData();


    }





    private void   getData(){
         String url = "https://shop.com/index.php";

         url = url+ "&pg="+ String.valueOf(token);

        Pbar.setVisibility(View.VISIBLE);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //   Toast.makeText(getApplicationContext(),"volly ok ",Toast.LENGTH_LONG).show();
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);
                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {
                                //getting product object from json array
                                JSONObject product = array.getJSONObject(i);
                                //adding the product to product list
                                productList.add(new Product(
                                        product.getInt("id"),
                                        product.getString("title"),
                                        product.getString("shortdesc"),
                                        product.getString("type"),
                                        product.getString("price"),
                                        product.getString("image")
                                ));
                            }
                            a.notifyDataSetChanged();



                            Pbar.setVisibility(View.GONE);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Server Error" ,Toast.LENGTH_LONG).show();
                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }

}