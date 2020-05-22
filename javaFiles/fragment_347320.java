@Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

                if (convertView == null) {

                    // all this is very slow, that's why we only do it when
                    // convertView is null, because it's common to all items.
                    // once a view is created, we will reuse this to show another row

                    convertView = inflater.inflate(R.layout.group_view, null);
                    TextView textGroup = (TextView) convertView.findViewById(R.id.groupNamesTV);
                    ImageView imgGroup = (ImageView) convertView.findViewById(R.id.indicator);
                    convertView.setTag(new ViewHolderForGroup(textGroup, imgGroup));

                } 

                // regardless of convertView is newly created or recycled, the TAG will now always contain the ViewHolder
                ViewHolderForGroup groupHolder = (ViewHolderForGroup) convertView.getTag();

                groupHolder.imageView.setImageResource(isExpanded?R.mipmap.down:R.mipmap.right);
                groupHolder.txtView.setText(groupnames.get(groupPosition));
                return convertView;
            }