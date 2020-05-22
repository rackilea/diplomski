holder.titleOfDream.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (holder.descriptionOfDream.getVisibility() == View.GONE)
        {
            //expandedChildList.set(arg2, true);
            holder.descriptionOfDream.setVisibility(View.VISIBLE);
            holder.descriptionOfDream.requestLayout();
        }
        else
        {
            //expandedChildList.set(arg2, false);
            holder.descriptionOfDream.setVisibility(View.GONE);
            holder.descriptionOfDream.requestLayout();
        }

    }
});