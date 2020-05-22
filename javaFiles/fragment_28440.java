static final int X = 380, Y = 250;
static BufferedImage img = new BufferedImage(X, Y, BufferedImage.TYPE_INT_RGB);

static public void main(String[] args){

   WritableRaster wr = img.getRaster();

   int[] a = new int[3]; // 96 bit pixels
   a[0] = ...
   a[1] = ...
   a[2] = ...
   wr.setPixel(20, 20, a);

 }