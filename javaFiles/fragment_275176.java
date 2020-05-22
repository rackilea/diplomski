package com.example.alztrimakis;


import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

public class contact extends Activity {

ListView list;
LazyImageLoadAdapter adapter;

JSONParser jParser = new JSONParser();
private static final String TAG_nom = "nom";
private static final String TAG_prenom = "prenom";
private static final String TAG_relation = "relation";
private static final String TAG_SUCCESS = "success";
private static final String TAG_photo = "photo";
private static final String TAG_pers = "idpersonne";
 SharedPreferences pref;

 String [] tabphoto, tabnom, tabprenom, tabrelation, tabidpers;
private ProgressDialog pDialog;
String idp ;


@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.contact);

    list=(ListView)findViewById(R.id.listViewcontact);

    loadReps verif = new loadReps();
    verif.execute();
    Log.d("load","ok");
    Log.d("tabphoto",tabphoto.toString());
    Log.d("tabnom",tabnom.toString());
    Log.d("tabprenom",tabprenom.toString());
    Log.d("tabrelation",tabrelation.toString());
    Log.d("tabidpers",tabidpers.toString());



}
 public void onItemClick(int mPosition)
{
    String tempValues = tabphoto[mPosition];
    String idperss = tabidpers[mPosition];

    Toast.makeText(contact.this, 
            "Image URL : "+tempValues+" dest "+idperss, 
            Toast.LENGTH_LONG)
    .show();
}

// Image urls used in LazyImageLoadAdapter.java file

class loadReps extends  AsyncTask<String, String, String> {


     JSONObject tt;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(contact.this);
            pDialog.setMessage("Chargement...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
            Log.d("onpreExec","ok");
        }
        @Override
        protected String doInBackground(String... args) {

            Log.d("back","ok");
            pref = getSharedPreferences("memtrimakis",0);
             idp = pref.getString("idpatient", "no");       
            if (idp != "no")
            {
            ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("idpatient",idp));
            IWebServices webServices = new WebServices();
            try {
            String result = webServices.getResult("affcontacts.php",nameValuePairs);
            JSONObject json = new JSONObject(result);
            Log.d("rep:", json.toString());
                int success = json.getInt(TAG_SUCCESS);
                selectip ipaddresse =new selectip();
                if (success == 1) {
                    tabphoto = new String[json.length()];
                    tabnom = new String[json.length()];
                    tabprenom = new String[json.length()];
                    tabrelation = new String[json.length()];
                    tabidpers = new String[json.length()];
                for (int i=0; i<json.length();i++)
                     {
                    tt = (JSONObject) json.get(String.valueOf(i));
                    tabphoto[i] = ipaddresse.adresseip().toString()+"img/"+tt.getString(TAG_photo);
                    tabnom[i]= tt.getString(TAG_nom);
                    tabprenom[i]= tt.getString(TAG_prenom);;
                    tabrelation[i]= tt.getString(TAG_relation);
                    tabidpers[i]= tt.getString(TAG_pers);
                     }


                }
                }

            catch (Exception e) {
                 e.printStackTrace();
            }
            }
                return null;
            }
        @Override
            protected void onPostExecute(String file_url) {


                Log.d("post","ok");
                runOnUiThread(new Runnable() {
                    @Override

                    public void run() {
                        for (int j=0; j<tabphoto.length;j++)
{Log.d("tabphotob"+j,tabphoto[j]);}


                    }
                });
 // Create custom adapter for listview
        adapter= new LazyImageLoadAdapter(contact.this, tabphoto, tabnom, tabprenom, tabrelation);
        Log.d("adapter","ok");
        //Set adapter to listview
        list.setAdapter(adapter);
                    if(pDialog != null)
                        pDialog.dismiss(); 


                }

 }

}