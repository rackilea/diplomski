@Override
public boolean onCreateOptionsMenu(Menu menu)
{
    getMenuInflater().inflate(R.menu.main, menu);
    MenuItem menuItem = menu.findItem(R.id.user_image);
    View actionView = menuItem.getActionView();
    actionView.setBackgroundColor(Color.RED);

    ImageView imageView = actionView.findViewById(R.id.icon_main);
    imageView.setImageResource(R.drawable.user_image_black);
    return true;
}