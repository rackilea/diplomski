// loop through each 10th column in the camera
for (int i=0;i<cam.width;i+=10) {

    // loop through each 10th row in the camera
    for (int j=0;j<cam.height;j+=10) {            

        // calculate the pixel location at (i, j)
        int loc=i+(j*cam.width);

        // check the pixel is red
        if (cam.pixels[loc]==color(255, 0, 0)) {

            // loop through each column in the gif image
            for (int x=0;x<10;x++) {

                // loop through each row in the gif image
                for (int y=0;y<10;y++) {

                    int locDos = (i + x) + ((j + y) * cam.width);
                    cam.pixels[locDos]=hoja.get(x, y);
                }
            }
        }
    }
}