public ColorType next() {
   ColorType temp = circles[0];
   circles[0] = circles[1];
   circles[1] = circles[2];
   circles[2] = circles[3];
   circles[3] = temp;

   System.out.println(circles[0] + ", " + circles[1] + ", " + circles[2] + ", " + circles[3]);

   return circles[0]; 
}