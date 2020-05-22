// Algorithm Only
void setOpacityOfColor(char r, char g, char b, char opacToSet, RGBAType image[][]){

    for(int x = 0; x < image.width; x++){
        for(int y = 0; y < image.height; y++){
            if(image[x][y].r == r && image[x][y].g == g && image[x][y].b == b{
                image.alpha = opacToSet;
            }
        }
    }

}