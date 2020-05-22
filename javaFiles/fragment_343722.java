class HomeItemModel{
    private int mWeight;
    private String mCat;

    HomeItemModel(String cat, int weight){
        mWeight = weight;
        mCat = cat;
    }
    public int getWeight(){
        return mWeight;
    }
    public String getCategory(){
        return mCat;
    }
    /*More code*/
}