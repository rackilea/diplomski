private void nextImage() {
    Random rand = new Random();
    int rndN = rand.nextInt(16)+ 1 ; 
    String imgName = "dog" + rndN;
    int id = getResources().getIdentifier(imgName, "drawable", getPackageName());
    if (id == 0) {
        imgName = "cat" + rndN;
        id = getResources().getIdentifier(imgName, "drawable", getPackageName());
    }
    image.setImageResource(id);
}