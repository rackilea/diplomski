for(int i=0; i<listOfObjects.length; i++) {
   Object obj = listOfObjects[i];

   if (obj instanceof Triangle) {
      Triangle t = (Triangle) obj;
      t.getArea();
   } else if (obj instanceof Rectangle) {
      Rectangle r = (Rectangle) obj;
      r.getPerimeter();
   } else {
      Sphere s = (Sphere) obj;
      s.getSomeOtherThing();
   }
}