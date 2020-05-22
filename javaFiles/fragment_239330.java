if (position == 0) {
    holder.zeroIcon.setVisibility(View.VISIBLE);
    holder.otherIcon.setVisiblity(View.GONE);
    holder.oneIcon.setVisiblity(View.GONE);
} else if (position == 1) {
    holder.oneIcon.setVisiblity(View.VISIBLE);
    holder.zeroIcon.setVisibility(View.GONE);
    holder.otherIcon.setVisiblity(View.GONE);
} else {
    holder.otherIcon.setVisiblity(View.VISIBLE);
    holder.oneIcon.setVisiblity(View.GONE);
    holder.zeroIcon.setVisibility(View.GONE);
}