try{
    Properties properties = new Properties();
    properties.load(this.getActivity().getAssets().open("app.properties"));
}catch(Exception e){
    e.printStackTrace();
}