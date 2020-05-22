if (isConnected){

BusProvider.getInstance().post(new InternetAvailable(true));

}else{

BusProvider.getInstance().post(new InternetAvailable(false));
Toast.makeText(context, R.string.no_internet, Toast.LENGTH_LONG).show();

}