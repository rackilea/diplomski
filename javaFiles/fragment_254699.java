import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

public class ContactUtils {

    private ContactUtils() {
    }

    public static List<Contact> parseContacts(Cursor cursor) {
        List<Contact> contacts = new ArrayList<>();

        if (cursor.getCount() == 0) {
            return contacts;
        }

        int nameColumnIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY);
        int idColumnIndex = cursor.getColumnIndex(ContactsContract.Contacts._ID);
        int numberColumnIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);

        while (cursor.moveToNext()) {
            String contactName = cursor.getString(nameColumnIndex);
            String id = cursor.getString(idColumnIndex);
            String number = cursor.getString(numberColumnIndex);

            Contact contact = new Contact(id, contactName, number);
            if(!isContactAddedInList(contact, contacts)){
                contacts.add(contact);
            }

        }

        return contacts;
    }

public boolean isContactAddedInList(Contact contact, List<Contact> contacts) {

    for (Contact listContact : contacts
            ) {
        if (listContact.number.equals(contact.name)) {
            return true;
        }
    }

    return false;
}


}