try {
    GifDrawable gif = new GifDrawable(bytes);
    imgExerciseImage.setImageDrawable(gif);
} catch (IOException e) {
    e.printStackTrace();
}