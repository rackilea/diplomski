try{
    Properties properties = new Properties();
    properties.load(MyApp.getContext().getAssets().open("app.properties"));
}catch(Exception e){
    e.printStackTrace();
}