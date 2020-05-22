public void setPixel(int x, int y, float a, float r, float g, float b){

    // Check for invalid values
    if((x < 0 || x>= width || y < 0 || y>= height) || a == 0){
        // Break out of function if invalid values detected
        return;
    }

    // Update pixel
    int index = (x + y * width) * 4;
    pixels[index] = (byte)((a * 255f) + 0.5f);
    pixels[index + 1] = (byte)((b * 255f) + 0.5f);
    pixels[index + 2] = (byte)((g * 255f) + 0.5f);
    pixels[index + 3] = (byte)((r * 255f) + 0.5f);
}