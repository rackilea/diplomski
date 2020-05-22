@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_category);

    myDb = new MyDatabase(this);
    recyclerCategory = (RecyclerView) findViewById(R.id.recyclerCategory);

     CategoryType = CaseActivity.CategoryType;
     Log.d(GlobalConstant.KEY_CATEGORY_TYPE, "" + CategoryType);

     allCategory = myDb.getCategoryByType(CategoryType);

     if (allCategory.size() == 0) {
         Toast.makeText(this, "No Category", Toast.LENGTH_SHORT).show();
    }    

    adapter = new CategoryAdapter(allCategory);
    recyclerCategory.setAdapter(adapter);
    layoutManager = new LinearLayoutManager(this);
    recyclerCategory.setLayoutManager(layoutManager);
    recyclerCategory.setItemAnimator(new DefaultItemAnimator());
    recyclerCategory.setHasFixedSize(true);
}