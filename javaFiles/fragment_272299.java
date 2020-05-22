public View getView(int position, View convertView, ViewGroup parent){
    ViewHolder holder;
    if (convertView == null) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.document_cell,parent,false);
        holder = new ViewHolder();
        holder.docTitle = (TextView) v.findViewById(R.id.name); 
        holder.docType = (TextView) v.findViewById(R.id.doctype);
        holder.docMod = (TextView) v.findViewById(R.id.modified);
        holder.docImage = (ImageView) v.findViewById(R.id.docicon);
        convertView.setTag(holder);
    }
    else
     {
          holder =(ViewHolder) convertView.getTag();    
     } 
      // with list update ui here

        holder.docTitle.setTypeface(myTypeFace);
        holder.docTitle.setTextColor(Color.parseColor(bgColor));
        holder.docType.setTypeface(myTypeFace);
        holder.docMod.setTypeface(myTypeFace);

    return convertView;
}

static class ViewHolder
{
       TextView docTitle,docStyle,docType,docMod;
       ImageView docImage; 
}