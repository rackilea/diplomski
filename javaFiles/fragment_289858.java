try {
    imagenView.setImageResource(imagen);
} catch (OutOfMemoryError e) {
    //fill your ImageView with something smaller .. maybe a smaller resolution
    Log.e("PlaceholderFragment", "Error: OutOfMemoryError")
}