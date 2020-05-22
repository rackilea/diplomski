public class ImageAdapter extends BaseAdapter {
        private Context context;
        private final String[] teamValues;

        public LayoutInflater inflater;
        public LinearLayout ll;

        public ImageAdapter(Context context, String[] teamValues) {
            this.context = context;
            this.teamValues = teamValues;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View gridView;

            if (convertView == null) {

                gridView = new View(context);

                // get layout from player.xml
                gridView = inflater.inflate(R.layout.player, null);

                // set value into textview
                ll = (LinearLayout)gridView.findViewById(R.id.linear1);
                TextView textView = (TextView) gridView
                        .findViewById(R.id.grid_item_team_name);
                textView.setText(teamValues[position]);

                String team = teamValues[position];
                // add team members here
                //
                //
                //                    

            } else {
                gridView = (View) convertView;
            }

            return gridView;
        }
    }