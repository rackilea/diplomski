class Child extends Base{
      @Override
      protected void a(){

      }

      public void a2() {
           a(); //This would have the same problems that allowing to increase the visibility.
      }
}