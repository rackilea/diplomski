viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
    Intent intent = FooPager.newIntent(getActivity(), position);
    startActivity (intent);
    // mListener.OnGalleryImageSelected(imageResId);
    }
});