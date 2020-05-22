HttpClient httpclient = new DefaultHttpClient();
String url = "https://graph.facebook.com/me/friends?access_token=" + URLEncoder.encode(token);
HttpGet httppost = new HttpGet(url);
try {
                HttpResponse response = httpclient.execute(httppost);

                // to get the response string
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                response.getEntity().getContent(), "UTF-8"));
                // used to construct the string
                String res = "";
                for (String line = null; (line = reader.readLine()) != null;) {
                    res += line + "\n";

                }
// here we will parse the response
                JSONObject obj = new JSONObject(new JSONTokener(res));
                JSONArray data = obj.getJSONArray("data");
int len = data.length();
for (int i = 0; i < len; i++) {
                    JSONObject currentResult = data.getJSONObject(i);
                    String name = currentResult.getString("name");
                    String icon = currentResult.getString("id");

                    // do what ever you want

                }
} catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }