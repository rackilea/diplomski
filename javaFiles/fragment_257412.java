class Test{
    private static Test mObject;
      private Test()
      {
      }
    public static Test getInstance(){
      if(mObject==null){
         mObject=new Test();
      } 
         return mObject;
    }

    }