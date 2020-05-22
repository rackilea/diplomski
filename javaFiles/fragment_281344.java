//don't display 0 if there are no footprints
if (viewHolder.footprints.getText().equals("0"))
    viewHolder.footprints.setVisibility(View.GONE);
else
    viewHolder.footprints.setVisibility(View.VISIBLE);

double[] loc = post.getLocation().get(0);
viewHolder.distance.setText("~" + PostListFragment.distance(loc[0], loc[1], 'M') + " Miles");