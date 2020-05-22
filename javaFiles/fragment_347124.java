Runnable mlauncher = () -> {
    try {

      driver.get(url);
     } catch (Exception e) {
          e.printStackTrace();
       }
    };

public void myfunction {
 try {

   Thread mthread = new Thread(mlauncher);
   mthread.start

  robot.keyPress(KeyEvent.VK_ENTER);
  robot.keyRelease(KeyEvent.VK_ENTER);

 } catch (Exception e) {
          e.printStackTrace();
       }