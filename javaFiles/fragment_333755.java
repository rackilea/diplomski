public class DisplayList extends ListActivity
{
    login[] values;

    protected void onCreate(Bundle savedInstanceState)
    {
        String username, password;
        int count = 0;

        values = new longin[somelength];
        // ^^^^   initialize your array 

        while (count < somelength)
        {
            username = somestring;
            password = somestring;
            values[count] = new login(username, password);
            count++;
        }
        login_adapter = new login_adapter(this, values);
        // make sure the login_adapter class name and object name is different            
        setListAdapter(login_adapter);
    }
}