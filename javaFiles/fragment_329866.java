public class LazyAdapter extends BaseAdapter {

    private Activity activity;
    private String[] data;
    private static LayoutInflater inflater=null;
    public ImageLoader imageLoader;
    private List<User> userList;

    public LazyAdapter(Activity a, String[] d) {
        activity = a;
        data=d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader=new ImageLoader(activity.getApplicationContext());
    }

    public LazyAdapter(Activity b, String[] mStrings, List<User> user) {
        activity = b;
        data=mStrings;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader=new ImageLoader(activity.getApplicationContext());
        userList = user;
    }

    // ---- here be ur other code ----

    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.item, null);

        TextView text=(TextView)vi.findViewById(R.id.text);
        TextView text1=(TextView)vi.findViewById(R.id.text1);
        ImageView image=(ImageView)vi.findViewById(R.id.image);
        text.setText("Name: " +userList.get(position).getFirstName()+" "+userList.get(position).getLastName());
        text1.setText("Gender: " +userList.get(position).getGender());
        imageLoader.DisplayImage(data[position], image);
        return vi;
    }
}