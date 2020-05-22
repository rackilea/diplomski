private void setX(){
   System.out.println("hello");
   synchronized (this) {
      this.x = 42;
      this.y = 37;
   }
   System.out.println("bye");
}