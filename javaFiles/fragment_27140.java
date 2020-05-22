PImage sprite = new PImage(7,5,RGB);
sprite.pixels = new int[]{color(255),color( 0 ),color(255),color(255),color(255),color( 0 ),color(255),
                          color( 0 ),color(255),color( 0 ),color(255),color( 0 ),color(255),color( 0 ),
                          color(255),color(255),color(255),color(255),color(255),color(255),color(255),
                          color( 0 ),color(255),color( 0 ),color(255),color( 0 ),color(255),color( 0 ),
                          color(255),color( 0 ),color( 0 ),color( 0 ),color( 0 ),color( 0 ),color(255)};

sprite.updatePixels();

noSmooth();
image(sprite,0,0,70,50);