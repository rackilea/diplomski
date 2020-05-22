ImageReader.getImagesUrls(this, "https://myrstcco.000webhostapp.com/productionData.json", new ICallback<ArrayList<String>>() 
{
            @Override
            public void onSucess(ArrayList<String> urls) {
                 PagerAdapter adapter = new ProductionViewPagerAdapter(this, urls);
                 //continue here...
            }
            @Override
            public void onError(String message, int code) {
                 throw new RuntimeException("Error not treated: "+message + " " + code);
            }
}
);