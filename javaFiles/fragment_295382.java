public static int average(int argb1, int argb2){
   return (((argb1       & 0xFF) + (argb2       & 0xFF)) >> 1)       | //b
          (((argb1 >>  8 & 0xFF) + (argb2 >>  8 & 0xFF)) >> 1) << 8  | //g
          (((argb1 >> 16 & 0xFF) + (argb2 >> 16 & 0xFF)) >> 1) << 16 | //r
          (((argb1 >> 24 & 0xFF) + (argb2 >> 24 & 0xFF)) >> 1) << 24;  //a
}