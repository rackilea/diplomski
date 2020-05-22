@Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.group_view, null);
            groupname = (TextView) convertView.findViewById(R.id.groupNamesTV);
             imageView = (ImageView) convertView.findViewById(R.id.indicator);
            convertView.setTag(new ViewHolderForGroup(groupname , imageView));
            group = (ViewHolderForGroup) convertView.getTag();

        } else {

            // we have a view previously created, our stuff is in the TAG
            group = (ViewHolderForGroup) convertView.getTag();
            imageView = group.imageView; // or whatever its name is             
        }




        if(isExpanded)
        {
            imageView.setImageResource(R.mipmap.down);


        }else {
            imageView.setImageResource(R.mipmap.right);
        }

        group.txtView.setText(groupnames.get(groupPosition));
        return convertView;
    }