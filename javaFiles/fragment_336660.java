public boolean isInside(int n) {
    if(n >= topLeftIndex && n <= bottomRightIndex) {
        if(n % mapWidth >= topLeftIndex % mapWidth
          && mapWidth % mapWidth <= bottomRightIndex % mapWidth) {
            return true;
        }
    }
    return false;
}