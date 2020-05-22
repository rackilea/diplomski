public View getView(final int position, View convertView, ViewGroup parent) {
            LinearLayout view;
            if (convertView == null) //Regenerate the view
            {

              /* inflate Draws my views */

            } else 
            {
                view = (LinearLayout) convertView;

            }

            //repopulate this view with the data that needs to appear at this position using getItem(position)


            return view;
        }