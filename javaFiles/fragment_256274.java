public class CustomAdapter extends ArrayAdapter<String>{

    ArrayList<String> id, name, email, phno;
    Context c;


    public CustomAdapter(Context context,   ArrayList<String>id, ArrayList<String>name , ArrayList<String>email , ArrayList<String> phno ){
        super(context,R.layout.custom_row, id);

        this.c=context;
        this.id = id;
        this.name=name;
        this.email=email;
        this.phno=phno;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater harshitsInflator = LayoutInflater.from(getContext());
        View customView = harshitsInflator.inflate(R.layout.custom_row, parent, false);

        TextView textView3 = (TextView) customView.findViewById(R.id.textView3);
        TextView textView4 = (TextView) customView.findViewById(R.id.textView4);
        TextView textView5 = (TextView) customView.findViewById(R.id.textView5);
        Button button4 = (Button) customView.findViewById(R.id.button4);


            String Sid = id.get(position);
            String Sname = name.get(position );
            String Semail = email.get(position );
            String Sphno = phno.get(position);

            textView3.setText(Sname);
            textView4.setText(Semail);
            textView5.setText(Sphno);
            button4.setText(Sid);

        return customView;
    }
}