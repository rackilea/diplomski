package com.samjanz.xmlparsing;

import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.samjanz.xmlparsing.helpers.MyConverter;
import com.samjanz.xmlparsing.helpers.MyHTTPConnector;
import com.samjanz.xmlparsing.pojos.Calendar;
import com.thoughtworks.xstream.XStream;

public class XmlParsingActivity extends Activity {

LinearLayout parent;
String serverResponce;
Document xmlDoc;
ArrayList<Calendar> calendarList;

/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    parent = (LinearLayout) findViewById(R.id.parent);
    XStream xstream = new XStream();
    xstream.alias("calendar", Calendar.class);

    calendarList = new ArrayList<Calendar>();
    String url = getText(R.string.calendar_url).toString();
    // get DOC
    xmlDoc = MyConverter.streamToDocument(MyHTTPConnector.UrlToStream(url));
    NodeList nodeLst = xmlDoc.getElementsByTagName("calendar");

    for (int i = 0; i < nodeLst.getLength(); i++) {
        Node node = nodeLst.item(i);
        if (node != null) {
            Calendar obj = (Calendar) xstream.fromXML(MyConverter
                    .nodeToString(node));
            calendarList.add(obj);
            LayoutParams lparams = new LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            TextView tv = new TextView(this);
            tv.setLayoutParams(lparams);
            tv.setText("\n\nLoop No:" + (i + 1) + "\nId = "
                    + calendarList.get(i).getId() + "\nName = "
                    + calendarList.get(i).getName() + "\nExpiry Date = "
                    + calendarList.get(i).getExpiryDate()
                    + "\nThumbnail Url = "
                    + calendarList.get(i).getThumbnailUrl());
            parent.addView(tv);

        }

    }
}