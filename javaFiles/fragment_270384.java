PImage img, two, sorted;

void setup() {
    size(736,1051); 
    img = loadImage("guy.png");
    two = loadImage("guy2.png");
    background(two);  
}

void draw() {
    loadPixels();
    for (int y = 0; y < height; y++) { 
        for (int x = 0; x < width; x++) {
            int loc = x + y*width;
            float r = red(img.pixels[loc]), g = green(img.pixels[loc]), b = blue(img.pixels[loc]);
            pixels[loc] =  color(g,b,r, 17); //I know r, g, b are switched here
       }  
    }        
    updatePixels();
    save("guy_coloured.png"); 
}

void Swap(PImage toSort, int i1, int i2) {
    color c = toSort.pixels[i1];
    toSort.pixels[i1] = toSort.pixels[i2];
    toSort.pixels[i2] = c;
}

int Sort(PImage toSort, int start, float b_min, float b_max) {

    for (int i = start; i < toSort.pixels.length; i++) {
        float b = brightness(toSort.pixels[i]);
        if (b >= b_min && b < b_max) {
            Swap(toSort, i, start);
            start ++;
        }
    }
    return start;
}

void keyPressed(){
    sorted = loadImage("guy_coloured.png");
    sorted.loadPixels();
    image(sorted, 0, 0);

    System.out.print("doing it");

    int j = 0;
    j = Sort(sorted, j, 0.0, 50.0);
    j = Sort(sorted, j, 0.50, 100.0);
    j = Sort(sorted, j, 0.100, 150.0);
    j = Sort(sorted, j, 0.150, 200.0);
    j = Sort(sorted, j, 0.200, 256.0);

    System.out.print("done");
    sorted.updatePixels();

    image(sorted, 0, 0);
    save("guy_sorted.png"); 
    noLoop();
}