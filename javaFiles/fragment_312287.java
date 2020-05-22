public void changeImage(int position, int image){
    if(position >= 0 && position < images_id.length){
        image_id[position] = image;
        notifyDataSetChanged();
    }
}