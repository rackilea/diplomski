Uri u = getContactImage();
if (u != null) {
        mImageView.setImageURI(u);
} else {
        mImageView.setImageResource(R.drawable.ic_launcher);
}