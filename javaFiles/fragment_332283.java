class Box {
     private final int height;

     public Box(int h){
         height = h;
     }

     @Override
     public String toString(){
         return Integer.toString(height);
     }
}