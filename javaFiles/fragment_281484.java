if (bwidth / swidth <  bheight / sheight) {
    new_width = swidth;
    new_height = (int) Math.floor((double) bheight 
                                  * (double) swidth / (double) bwidth);
} else {
    new_height = sheight;
    new_width = (int) Math.floor((double) bwidth 
                                 * (double) sheight / (double) bheight);
}