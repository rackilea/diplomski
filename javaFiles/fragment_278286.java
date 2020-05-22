PRELOAD = 10; // number of pages to preload
img = 56;
for(int i = 0; i < PRELOAD; i++) {
  if(images[img+i] != null) {
    images[img+i] = new ImageIcon ((img + i) + ".jpg");
  }
}