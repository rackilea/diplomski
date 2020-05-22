Class Test{
    Student ken = new Student('ken');

    public void LockTest() {

      synchronized(ken){
        doSomething();
      }
    }
}