public class TaskAdapter extends BaseAdapter
        {
            private Context mContext;

            public TaskAdapter(Context c)
            {
                mContext = c;
            }

            @Override
            public int getCount()
            {
                return nThumbsIds.size();
            }

            @Override
            public Object getItem(int position)
            {
                // TODO Auto-generated method stub
                return nThumbsIds.get(position);
            }

            @Override
            public long getItemId(int position)
            {
                // TODO Auto-generated method stub
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {
                TextView tView =null;
                Button tBtn =null;

                LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
                convertView = inflater.inflate(R.layout.task_square, parent, false);

                 tView = (TextView) convertView.findViewById(R.id.grid_item_txv);
                 tBtn = (Button) convertView.findViewById(R.id.grid_item_btn);

                if(position < nThumbsIds.size()-1)
                {
                    tView.setText(nThumbsIds.get(position));
                    tView.setVisibility(View.VISIBLE);
                    tBtn.setVisibility(View.GONE);
                }
                else
                {
                    tBtn.setText(nThumbsIds.get(position));
                    tView.setVisibility(View.GONE);
                    tBtn.setVisibility(View.VISIBLE);
                }

                return convertView;
            }