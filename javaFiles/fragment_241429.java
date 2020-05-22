URL url; // ...
Proxy proxy; // ...
HttpURLConnection conn = url.openConnection(proxy);
conn.setDoOutput(true); // changes the request method to POST
OutputStream out = conn.getOutputStream();
// Write the POST parameters to 'out'
int responseCode = conn.getResponseCode();
if (responseCode == 200)
{
    // read response from conn.getInputStream();
}
else
{
    // read error from conn.getErrorStream();
}