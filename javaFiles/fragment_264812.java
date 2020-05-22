public static void main(String[] args) {
      XGetProgramGuideDirectTestControllerCmdImpl PGDirTestController = new 
               XGetProgramGuideDirectTestControllerCmdImpl();
      try {
          PGDirTestController.performExecute();
      } catch(ECException e) { 
            e.printStackTrace();
            //Handle the exception!
        }
}