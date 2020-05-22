public ImageView get_image_by_name(String name)
{
    int image_id = getResources().getIdentifier(name , "drawable", getPackageName());
    ImageView iv = new ImageView(this);
    ViewGroup.LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    iv.setLayoutParams(lp);
    iv.setImageDrawable(getResources().getDrawable(image_id));
    return iv;
}