class Abc extends ASyncTask<String, String, String>
{
public String doInBackground(String... params)
 {
  URL url = null;
                url = new URL(et.getText().toString());
                URLConnection conn = url.openConnection();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line = "";
                while((line = reader.readLine()) != null){
                    tv.append(line);
 }
}