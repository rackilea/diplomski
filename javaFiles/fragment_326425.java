PImage[] images = new PImage[25];
size(1000,1000);

for(int i = 0; i < images.length; i++) {
  images[i] = loadImage(i + ".png");   // make sure images "0.png" to "24.png" exist
}

int i = 0;
float tileCountX = 5;
float tileCountY = 5;
float stepX = width/tileCountX;
float stepY = height/tileCountY;
for (float gridY = 0; gridY < height; gridY += stepY) {
  for (float gridX = 0; gridX < width; gridX += stepX) {
    image(images[i++], gridX, gridY, stepX, stepY);
  }
}