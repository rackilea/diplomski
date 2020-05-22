public class connectTask extends AsyncTask<String,String,String[]> {

    String FilmId, Name, Certificate, Duration, Director, Description, ReleaseDate, Cast; 
    @Override
    protected String[] doInBackground(String... message) {
    String[] jsonArr = new String[9];
        //we create a TCPClient object and
        mTcpClient = new TCPClient(new TCPClient.OnMessageReceived() {
            @Override
            //here the messageReceived method is implemented
            public void messageReceived(String message) {
                //this method calls the onProgressUpdate


                Log.e("TCP Client", message);




                try 
                {
                    JSONObject json = new JSONObject(message);
                    FilmId = (String) json.get("FilmId");
                    Name = (String) json.get("Name");
                    Certificate = (String) json.get("Certificate");
                    Duration =(String) json.get("Duration");
                    Director = (String) json.get("Director");
                    Description = (String) json.get("Description");
                    ReleaseDate = (String) json.get("ReleaseDate");
                    Cast = (String) json.get("Cast");
                    Log.e("FilmId: ", FilmId);
                    Log.e("Name: ", Name);
                    Log.e("Cert: ", Certificate);
                    Log.e("Duration: ", Duration);
                    Log.e("Director: ", Director);
                    Log.e("Description: ", Description);
                    Log.e("ReleaseDate: ", ReleaseDate);
                    Log.e("Cast: ", Cast);

    jsonArr [0] = FilmId;
jsonArr [1] = Name;

                } 
                catch (JSONException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }



            }
        });


        mTcpClient.run("GTF 02");
        System.out.println(jsonArr [1]);    



        return jsonArr ;
       }
    protected void onPostExecute(String[] JSON)
    {

    Intent FilmInfo = new Intent(this, FilmInfo.class);
    FilmInfo.putExtra("NamePass", JSON[1]);



    startActivity(FilmInfo);

    }
}


public void mLoadFilmInfo(View view) 
{

    //FilmID = "GTF "+ ButtonName;
    new connectTask().execute();


 }