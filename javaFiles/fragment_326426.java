PImage[] images = new PImage[25];
size(1000,1000);

// Save images
for (int i = 0; i < 25; i++) {
  try {
    Thread.sleep(750); //sleep 750 milliseconds before continuing
  } catch(InterruptedException ex) {
    ex.printStackTrace();
  }
  stroke (random(75, 150), random (200, 256), random(50, 150));
  float distance = random(200);
  strokeWeight(1);
  line (0, distance, 200, distance);    
  save(i+".png");
}
// Load images
for(int i = 0; i < images.length; i++) {
  images[i] = loadImage(i + ".png");   // make sure images "0.png" to "24.png" exist
}

// Display images
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