import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    public static final String TAG= "YOUR-TAG-NAME";
    private static final int REQUEST_PICK_CONTACT= 100;
    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent, REQUEST_PICK_CONTACT);
        SetpermissionReadContacts();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri result = data.getData();
        Log.v(TAG, "Got a result: " + result.toString());
        Cursor c;

// get the contact id from the Uri
        String id = result.getLastPathSegment();

// query for phone numbers for the selected contact id
        c = getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?",
                new String[]{id}, null);

        int phoneIdx = c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
        int phoneType = c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE);

        if(c.getCount() > 1) { // contact has multiple phone numbers
            final CharSequence[] numbers = new CharSequence[c.getCount()];
            int i=0;
            if(c.moveToFirst()) {
                while(!c.isAfterLast()) { // for each phone number, add it to the numbers array
                    String type = (String) ContactsContract.CommonDataKinds.Phone.getTypeLabel(this.getResources(), c.getInt(phoneType), ""); // insert a type string in front of the number
                    String number = type + ": " + c.getString(phoneIdx);
                    numbers[i++] = number;
                    c.moveToNext();
                }
                // build and show a simple dialog that allows the user to select a number
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
              //  builder.setTitle(R.string.select_contact_phone_number_and_type);
                builder.setItems(numbers, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        String number = (String) numbers[item];
                        int index = number.indexOf(":");
                        number = number.substring(index + 2);
                       // loadContactInfo(number); // do something with the selected number
                    }
                });
                AlertDialog alert = builder.create();
                alert.setOwnerActivity(this);
                alert.show();

            } else Log.w(TAG, "No results");
        } else if(c.getCount() == 1) {
            // contact has a single phone number, so there's no need to display a second dialog
        }

    }


    private void SetpermissionReadContacts() {
        // Check the SDK version and whether the permission is already granted or not.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_READ_CONTACTS);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        }
    }


}