Image image = new Image("tileset.png");

Rectangle2D viewport1 = new Rectangle2D(0,16,16,16); //(selected pixels)
int length = 40, width= 40;  // declare size of array (print 40x40)

// loop through grid, fill every tile with image 'image'. 
// currently only fills position (40,40) with the image. 
for(int y = 0; y < length; y++)
{
    for(int x = 0; x < width; x++)
    {
        ImageView tileset = new ImageView(image);
        tileset.setViewport(viewport1);

        GridPane.setConstraints(tileset,x,y);
        root.getChildren().add(tileset);
    }
}