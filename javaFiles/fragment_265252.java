Vector makeAndSetupVector(float f1, float f2, float f3, int y) {
   Vector vect = new Vector(f1, f2, f3);
   vect.addY(y);

   return vect;
}