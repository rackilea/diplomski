@Override
        public View getView(int position, View convertView, ViewGroup parent) {
                MyViewHolder mViewHolder;
                View v = convertView;
                if(convertView == null) {
                        convertView = inflater.inflate(R.layout.list_view_item, null);
                        mViewHolder = new MyViewHolder();

                        mViewHolder.tvTitle = detail(convertView, R.id.userNameBody, myList.get(position).getTitle());
                        mViewHolder.tvDesc  = detail(convertView, R.id.destinyMessageBody,  myList.get(position).getDescription());
                        mViewHolder.image = detail(convertView, R.id.profile_picture, myList.get(position).getImage());
                        convertView.setTag(mViewHolder);

                } else {
                        mViewHolder = (MyViewHolder) convertView.getTag();
                }

                .. your other code goes here 
        }