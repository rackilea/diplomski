NetActivity.java

package com.example.xmlparsingasync;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class NetActivity extends Activity {

String url = "http://api.androidhive.info/pizza/?format=xml";

// Progress dialog
ProgressDialog pDialog;

ArrayList<String> title;

ListView list;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_net);

list = (ListView) findViewById(R.id.list);
title = new ArrayList<String>();

if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
new XmlParsing(url).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{null});
else
new XmlParsing(url).execute(new String[]{null});

}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
getMenuInflater().inflate(R.menu.main, menu);
return true;
}

public class XmlParsing extends AsyncTask<String, Void, String> {

// variables passed in:
   String urls;
   // constructor
   public XmlParsing(String urls) {
       this.urls = urls;
   }

   @Override
protected void onPreExecute() {
    pDialog = ProgressDialog.show(NetActivity.this, "Fetching Details..", "Please wait...", true);
   }


   @Override
protected String doInBackground(String... params) {
    // TODO Auto-generated method stub

    URL url;
    try {

    url = new URL(urls);
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder();
Document doc = db.parse(new InputSource(url.openStream()));

doc.getDocumentElement().normalize();

NodeList nodeList = doc.getElementsByTagName("item");

for (int i = 0; i < nodeList.getLength(); i++) {

Node node = nodeList.item(i);

Element fstElmnt = (Element) node;
NodeList nameList = fstElmnt.getElementsByTagName("name");
Element nameElement = (Element) nameList.item(0);
nameList = nameElement.getChildNodes();
title.add(""+ ((Node) nameList.item(0)).getNodeValue());

System.out.println("name : "+((Node) nameList.item(0)).getNodeValue());

}

} catch (MalformedURLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (ParserConfigurationException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (SAXException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (IOException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}


return null;
}

   @Override
        protected void onPostExecute(String result) {
            if (pDialog.isShowing())
                pDialog.dismiss();

            list.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1,title));
        }

}
}


And this is our activity xml

activity_net.xml

<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    >   
    <ListView 
        android:id="@+id/list"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
                >        
    </ListView>


</LinearLayout>