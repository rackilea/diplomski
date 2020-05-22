PImage ref;
PImage output;
String filename = "maptest2.jpg";

// // //

//Here I skip some parts that are unchanged

// // //

void setup() {

  size(480, 360, P3D);
  surface.setResizable(true);

  ref = loadImage(filename);

  // create a copy of reference image with a black border
  output = createImage(ref.width+2, ref.height+2, RGB);

  for(int i=0; i < output.pixels.length; i++){
    output.pixels[i] = color(0);
  }

  output.updatePixels();
  output.set(1, 1, ref);

  surface.setSize(output.width, output.height);

  cam = new PeasyCam(this, output.width, output.height, 0, 1500);