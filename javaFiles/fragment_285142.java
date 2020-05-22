try {
        Class<?> util = Class.forName("com.gluonhq.forname.Util");
        Platform platform = (Platform) util.newInstance();
        System.out.println("Platform: " + platform.getPlatform());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
        Logger.getLogger(BasicView.class.getName()).log(Level.SEVERE, null, ex);
    }