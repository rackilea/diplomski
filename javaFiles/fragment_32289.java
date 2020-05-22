try {
     ClassLoader cl = this.getClass().getClassLoader();
     ImageIcon programIcon = new ImageIcon(cl.getResource("res/test.png"));
     setIconImage(programIcon.getImage());
  } catch (Exception whoJackedMyIcon) {
     System.out.println("Could not load program icon.");
  }