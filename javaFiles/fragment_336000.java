public View getView(final int position, View convertView, ViewGroup parent) {
    holder = null;

    if (convertView == null) {
        convertView = ((Activity) context).getLayoutInflater().inflate(R.layout.listview_item, null);

        holder = new ViewHolder(convertView);
        holder.rank = (TextView) convertView.findViewById(R.id.rank);
        holder.country = (TextView) convertView.findViewById(R.id.country);
        holder.population = (TextView) convertView.findViewById(R.id.population);
        holder.flag = (ImageView) convertView.findViewById(R.id.flag);

        convertView.setTag(holder);
    } else {
        holder = (ViewHolder) convertView.getTag();
    }

    // Here's the change

    resultp    =    data.get(position);      

    // Here's the change

    holder.rank.setText(resultp.get(MainActivity.RANK));
    holder.country.setText(resultp.get(MainActivity.COUNTRY));
    holder.population.setText(resultp.get(MainActivity.POPULATION));
    imageLoader.DisplayImage(resultp.get(MainActivity.FLAG), holder.flag);
    return convertView;
}