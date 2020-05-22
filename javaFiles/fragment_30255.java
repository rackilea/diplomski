import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class contacts extends Activity {

TextView num1, num2, num3, name1, name2, name3;
Button saveNums, pick1Btn, pick2Btn, pick3Btn;
Context c = this;
public static String filename = "sharedString";
SharedPreferences prefs;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.contactsettings_layout);
    prefs = PreferenceManager.getDefaultSharedPreferences(this);
    uiBinder();
    btnManger();
}

public void uiBinder(){
    name1 = (TextView) findViewById(R.id.iceName1);
    name2 = (TextView) findViewById(R.id.iceName2);
    name3 = (TextView) findViewById(R.id.iceName3);
    num1 = (TextView) findViewById(R.id.iceNum1);
    num2 = (TextView) findViewById(R.id.iceNum2);
    num3 = (TextView) findViewById(R.id.iceNum3);
    saveNums = (Button) findViewById(R.id.saveICEBtn);
    pick1Btn = (Button) findViewById(R.id.contactPickBtn);
    pick2Btn = (Button) findViewById(R.id.contact2PickBtn);
    pick3Btn = (Button) findViewById(R.id.contact3PickBtn);
}

public void btnManger(){

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
    // This intent will fire up the contact picker dialog
    Intent intent = new Intent(Intent.ACTION_PICK,
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
    startActivityForResult(intent, view.getId());
        }
    };

    pick1Btn.setOnClickListener(click);

    pick2Btn.setOnClickListener(click);

    pick3Btn.setOnClickListener(click);
}

public void onActivityResult(int reqCode, int resultCode, Intent data) {

    super.onActivityResult(reqCode, resultCode, data);

    switch (reqCode) {
        case (R.id.contactPickBtn) :
            if (resultCode == Activity.RESULT_OK) {
                Uri contactData = data.getData();
                Cursor cursor = getContentResolver().query(contactData, null, null, null, null);
                cursor.moveToFirst();
                String name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.PhoneLookup.DISPLAY_NAME));
                String number = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));
                name1.setText("Contact name: " + name);
                num1.setText("Contact number: " + number);
            }
            break;
        case (R.id.contactPick2Btn):
            if (resultCode == Activity.RESULT_OK) {
                Uri contactData = data.getData();
                Cursor cursor = getContentResolver().query(contactData, null, null, null, null);
                cursor.moveToFirst();
                String name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.PhoneLookup.DISPLAY_NAME));
                String number = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));
                name2.setText("Contact name: " + name);
                num2.setText("Contact number: " + number);
            }
            break;
        case (R.id.contactPick3Btn):
            if (resultCode == Activity.RESULT_OK) {
                Uri contactData = data.getData();
                Cursor cursor = getContentResolver().query(contactData, null, null, null, null);
                cursor.moveToFirst();
                String name = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.PhoneLookup.DISPLAY_NAME));
                String number = cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));
                name3.setText("Contact name: " + name);
                num3.setText("Contact number: " + number);
            }
            break;
    }
}
}