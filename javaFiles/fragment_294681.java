@Override
public View getView(int position, View convertView,  ViewGroup parent) {
    LayoutInflater inflater1 =  LayoutInflater.from(getContext());
    View customView = inflater1.inflate(R.layout.equipments_view , parent , false);


String tool = tools_names[position]; // change here to get from 1st array
String tool_defs = tools_def[position]; // change here to get from 2nd array
TextView tool_name = (TextView) customView.findViewById(R.id.tool_name);
TextView tool_def = (TextView) customView.findViewById(R.id.tool_def);
ImageView tool_image = (ImageView) 
customView.findViewById(R.id.tool_image);

tool_name.setText(tool);
tool_def.setText(tool_defs);
switch (position) {
    case 0:
        tool_image.setImageResource(R.drawable.a);
        break;
    case 1:
        tool_image.setImageResource(R.drawable.b);
        break;
    case 2:
        tool_image.setImageResource(R.drawable.c);
        break;
    case 3:
        tool_image.setImageResource(R.drawable.d);
    case 4:
        tool_image.setImageResource(R.drawable.e);
        break;
}
return customView;
}