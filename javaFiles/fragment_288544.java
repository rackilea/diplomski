@Override
            public View getView(int position, View convertView, ViewGroup parent){

                if(convertView == null)
                {
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater.inflate(R.layout.list_inner_view, parent, false);
                }

                TextView textView = (TextView) convertView.findViewById(R.id.textBookView);
                Phone current = phoneList.get(position);
                textView.setText(current.getPhoneName() + " - " + current.getAuthor());

                return convertView;
            }