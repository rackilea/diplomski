private int[] imageResId = {
            R.drawable.ic_home,
            R.drawable.ic_my_timeline,
            R.drawable.ic_my_pages,
            R.drawable.ic_my_groups,
            R.drawable.ic_liked_pages
    };

@Override
public CharSequence getPageTitle(int position) {
    Drawable image = mContext.getResources().getDrawable(imageResId[position]);
     image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
     SpannableString sb = new SpannableString(" ");
     ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
     sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
     return sb;
}