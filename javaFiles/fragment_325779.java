public static double calculateLengthToPaint(double angle, double heightOfSquare){
    double flippy = angle % 90;
    if (flippy > 45.0){
        flippy -= 90;
        flippy = Math.abs(flippy);
    }
      return  (heightOfSquare/2.0) / Math.cos(Math.toRadians(flippy));
}