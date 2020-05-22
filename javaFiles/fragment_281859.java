public class RefreshListView extends ListActivity{

    String[] names,phones,types,ids;
    String name,id,phoneNumber;
    int type;
    ArrayList <String> newValues;
    ContentResolver cr = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cr = getContentResolver();
        newValues=SetNewList.getNames();//getnames is of static type
        getContacts();
    }

    public void getContacts() {
        int foo = 0;

        // REMOVE THE NEXT LINE !!!
        // ContentResolver cr = getContentResolver();

        ...

    }
}