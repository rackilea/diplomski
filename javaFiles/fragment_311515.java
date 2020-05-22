final SplashScreen splash = SplashScreen.getSplashScreen();
if (splash == null) {
       System.out.println("SplashScreen.getSplashScreen() returned null");
            return;
   }
URL link;
   try {
        link = new URL("http://docs.oracle.com/javase/tutorial/uiswing/examples/misc/SplashDemoProject/src/misc/images/splash.gif");
       } catch (MalformedURLException ex) {
            System.out.println("MalformedURLException link:77");
            return;
       }
   try {
            splash.setImageURL(link);
       } catch (NullPointerException | IOException | IllegalStateException ex) {
            System.out.println("NullPointer or IO or IllegalState setImageUrl:85");
            return;
       }