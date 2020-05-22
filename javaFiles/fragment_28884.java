@Override
public View getView(int position, View view, ViewGroup parent) {

    LayoutInflater inflater = context.getLayoutInflater();
    View rowView= inflater.inflate(R.layout.simplerow, null, true);
    TextView firstname = (TextView) rowView.findViewById(R.id.firstname);
    TextView lastname = (TextView) rowView.findViewById(R.id.lastname);
    if(firstnamearray[position].equels("Joseph")){
    //setbackground color to your desired color
    rowView.setBackgroundColor(context.getResources().getColor(R.color.red));//color defined in xml
    }else{
    rowView.setBackgroundColor(context.getResources().getColor(R.color.white));// your default color
    }
    cardnumber.setText(firstnamearray[position]);

    expdate.setText(lastnamearray[position]);

    return rowView;
}