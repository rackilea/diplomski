public class NetTask extends AsyncTask<String, Integer, String>
{
    @Override
    protected String doInBackground(String... params)
    {
        java.net.InetAddress addr = null;
        try {
            addr = java.net.InetAddress.getByName(params[0]);
            return addr.getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }
}