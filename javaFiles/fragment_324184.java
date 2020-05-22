// Calculate the distance from the center to the edge
int side_width = (kernel_size-1)/2

for (int y = side_width; y < img.height-side_width; y++) {   // Skip top and bottom edges
    for (int x = side_width; x < img.width-side_width; x++) {  // Skip left and right edges
      float sumR = 0; // Kernel sum for this pixel
      float sumG = 0; 
      float sumB = 0; 

for (int ky = 0; ky <= kernel_size - 1; ky++) {
    for (int kx = 0; kx <= kernel_size - 1; kx++) {
        // Calculate the adjacent pixel for this kernel point
        int pos = (y - side_width + ky)*img.width + (x - side_width + kx);
        float rVal = red(img.pixels[pos]);
        float gVal = green(img.pixels[pos]);
        float bVal = blue(img.pixels[pos]);
        // Multiply adjacent pixels based on the kernel values
        sumR += kernel[ky][kx] * rVal;
        sumG += kernel[ky][kx] * gVal;
        sumB += kernel[ky][kx] * bVal; 
    }
}

  //For this pixel in the new image, set the rgb value
  //based on the sum from the kernel
  edgeImg.pixels[y*img.width + x] = color(sumR,sumG,sumB);
}