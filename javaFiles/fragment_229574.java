@Override
    public void onClick(View v) {

            try {

                position = listview
                        .getPositionForView((View) v.getParent()); // position is an integer variable which helps you identify which item's plus button  was clicked
                Log.v("Position id", "" + position);

                // do some manipulations 
                notifyDataSetChanged();

            } catch (Exception e) {

                Log.e("error", "error" + e.getMessage());

            }

            break;