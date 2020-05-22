@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (data != null && (requestCode == SELECT_IMAGE_CODE || requestCode == CAMERA_IMAGE)) {
        Uri imageUri = data.getData();
        View child = header.getChildAt(0);
        View image = child.findViewById(R.id.myProfile_avatar);
        Resources resources = getResources();
        ImageView imageX = (ImageView) image;

        imageX.setImageDrawable(resources.getDrawable(R.drawable.blank));
        Picasso.with(this).load(imageUri).into(imageX);
        profileAdapter.notifyDataSetChanged();
    }
}