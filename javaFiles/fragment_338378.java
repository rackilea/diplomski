try {
        ClassLoader cl = this.getClass().getClassLoader();
        ImageIcon img = new ImageIcon(cl.getResource("images/WalkingDown.gif"));
    }
    catch(Exception imageOops) {
        System.out.println("Could not load program icon.");
        System.out.println(imageOops);
    }