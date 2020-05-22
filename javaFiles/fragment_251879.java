NetworkInfo info = (NetworkInfo) ((ConnectivityManager) ctx
            .getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
if(info.isRoaming)
{
S.O.P("data roaming");
}