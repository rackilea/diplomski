PImage[] images = new PImage[20];
int frameNum = 0;

void setup() {
    size(280, 120);

    for ( int i = 0; i < images.length; i++ ) {
        images[i] = loadImage(i + ".jpg" );
    }

    frameRate(30);
}

void draw() {

    frameNum++;
    frameNum %= images.length;    
    image(images[frameNum], 0, 0);
}