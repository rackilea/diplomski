try {
    addresses = gcd.getFromLocation(latitude, longitude, 1);
} catch (IOException e) {
    // TODO Auto-generated catch block
    Log.e("MyTag", "MyMessage", e); // use this instead e.printStackTrace();
}

if(addresses != null && addresses.size() > 0){
    citylb.setText(addresses.get(0).getLocality());

    getWeather((String) citylb.getText());
}else{
    citylb.setText("No adresses found");
}