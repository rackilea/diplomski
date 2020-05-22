public int getRank(Object ob){

      Class cl=ob1.getClass();
      Method mthd=cl.getMethod("getRank");
      Integer output=(Integer)mthd1.invoke(ob);
      return output;

}