public class Utils {


    public static String getPostcode(Context context, double lat, double lng){
        Geocoder geoCoder = new Geocoder(context, Locale.getDefault());
        List<Address> address = null;

        if (geoCoder != null) {
            try {
                address = geoCoder.getFromLocation(lat, lng, 1);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            if (address.size() > 0) {
                return address.get(0).getPostalCode();
            }
        }
        return null;
    }


    public static boolean isNetworkAvailable(final Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}