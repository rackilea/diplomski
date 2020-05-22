@Override
public void onViewCreated(View v, Bundle savedInstanceState){
    super.onViewCreated(v,savedInstanceState);

    recipeList = getListView();
    recipeList.setOnItemClickListener(this);
}