switch (position) {
case 0:
    imageView.setImageResource(R.drawable.splash);
    imageView.setId(R.drawable.splash);
    return view;
case 1:
    imageView.setImageResource(R.drawable.girrafe);
    imageView.setId(R.drawable.girrafe);
    return view;
case 2:
    imageView.setImageResource(R.drawable.lion);
    imageView.setId(R.drawable.lion);
    return view;
case 3:
    imageView.setImageResource(R.drawable.monkey);
    imageView.setId(R.drawable.monkey);
    return view;
case 4:
    imageView.setImageResource(R.drawable.chicken);
    imageView.setId(R.drawable.chicken);
    return view;
default:
    return null;
}