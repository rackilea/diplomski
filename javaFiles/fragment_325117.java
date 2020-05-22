@Override
public View getView(int position, View convertView, ViewGroup parent) {
   ViewHolder holder = new ViewHolder();
    if (convertView == null) {
        inflater = (LayoutInflater) 
                   c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.custom_row, null);
        holder.englishTv=(TextView)convertView.findViewById(R.id.rowTitle);
        holder.sinhalaTv=(TextView)convertView.findViewById(R.id.rowSubtitle);
        convertView.setTag(holder);
    }else{
        holder = (ViewHolder) convertView.getTag();
    }
    holder.englishTv.setText(englishName[position]);
    holder.sinhalaTv.setText(sinhalaName[position]);
    return convertView;
}