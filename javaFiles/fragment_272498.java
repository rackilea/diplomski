package com.sample.mpassbook.mpassbook_d; 

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.sample.mpassbook.httpconnection.Httpmanager; 

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/** 
 * Created by abhil on 22/07/15. 
 */ 
public class ListActivity extends android.app.ListActivity {
    private ProgressDialog pDialog;
    private static String url="https://fierce-tundra-4082.herokuapp.com/transactions/?msisdn=456&account=123&from_date=2015-07-10&format=json";
//    public static final String TAG_acnum = "account_number"; 
//    public static final String TAG_mnum = "mobile_number"; 
    public static final String TAG_content = "content";
    public static final String TAG_bankid = "bank_id";
    public static final String TAG_status = "details";
    public static final String TAG_Date = "date";
    public static final String TAG_cval = "amount";
//    public static final String TAG_dval = "debit_val"; 
    public static final String TAG_bal = "balance";


    JSONArray content = null;

    ArrayList<HashMap<String, String>> contentlist;


    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);

        ListView lv = getListView();

        new getlist().execute();

    } 
    private class getlist extends AsyncTask<Void,Void,Void> {

        @Override 
        protected Void doInBackground(Void... params) {
            Httpmanager hm = new Httpmanager();
            // initialization to be added in you code.
            contentlist = new ArrayList<>();
            String jsonstr = hm.makeServiceCall(url, Httpmanager.get);

            Log.d("Response: ", "> " + jsonstr);

            if (jsonstr != null) {
                try { 
                    JSONObject jsonObject = new JSONObject(jsonstr);
                    content = jsonObject.getJSONArray(TAG_content);


                    for (int i = 0; i < content.length(); i++) {
                        JSONObject c = content.getJSONObject(i);

                        String bank_id = c.getString(TAG_bankid);
                        String details = c.getString(TAG_status);
                        String date = c.getString(TAG_Date);
                        String amount = c.getString(TAG_cval);
                        String balance = c.getString(TAG_bal);

                        HashMap<String, String> contents = new HashMap<String, String>();

                        contents.put(TAG_bankid, "TRANSACTION ID : " +bank_id);
                        contents.put(TAG_status, "" +details);
                        contents.put(TAG_Date,"" +date);
                        contents.put(TAG_cval, "" +amount);

                        contentlist.add(contents);
                    } 
                } catch (JSONException e) {
                    e.printStackTrace();
                } 
            } else { 
                Log.e("HttpManager", "Couldn't get any data from the url");
                runOnUiThread(new Runnable() {

                    public void run() { 

                        Toast.makeText(getApplicationContext(), "CHECK YOUR NETWORK CONNECTION", Toast.LENGTH_LONG).show();

                    } 
                }); 

            } 

            return null; 
        } 



        @Override 
        protected void onPreExecute() { 
            super.onPreExecute(); 
            pDialog = new ProgressDialog(ListActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        } 
        @Override 
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (pDialog.isShowing())
                pDialog.dismiss();

            ListAdapter adapter = new SimpleAdapter(ListActivity.this, contentlist, R.layout.item, new String[]{TAG_bankid, TAG_status, TAG_Date, TAG_cval},
                    new int[]{R.id.bankid, R.id.status, R.id.date, R.id.cval});
            setListAdapter(adapter);


        } 
    } 






}