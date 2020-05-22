public void display() {
    for(int i = 0; i < length; i++){
    if(i > 0){ 
      System.out.print(" ");
    }
    System.out.print(this.elements[i]);
   }
   System.out.println();
}