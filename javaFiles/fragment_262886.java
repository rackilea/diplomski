for(int i = 0; i < myShapes.length; i++)
{
     System.out.print("Object " + i + " is a");

     if(myShapes[i] instanceof Rectangle)
          System.out.print(" rectangle: ");

     else if(myShapes[i] instanceof Circle)
          System.out.print(" circle: ");

     else if(myShapes[i] instanceof Box)
          System.out.print(" box: ");

     else if(myShapes[i] instanceof Cylinder)
          System.out.print(" cylinder: ");

     System.out.println(myShapes[i].toString());

}