private void testBuild1(Build build) {
    System.out.println("Build: x,y,z");
    for (int x = 0; x < build.getWidth(); x++) {
      for (int y = 0; y < build.getHeight(); y++) {
        for (int z = 0; z < build.getLength(); z++) {
          System.out.println("{" + x + "," + y + "," + z + "}");
        }
      }
    }
    int[] limits = {build.getWidth(), build.getHeight(), build.getLength()};
    testNDS(new NDimensionalStepper(limits));
  }

  private void testBuild2(Build build) {
     System.out.println("Build: z,y,x");
    for (int z = 0; z < build.getLength(); z++) {
      for (int y = 0; y < build.getHeight(); y++) {
        for (int x = 0; x < build.getWidth(); x++) {
          System.out.println("{" + x + "," + y + "," + z + "}");
        }
      }
    }
    int[] limits = {build.getWidth(), build.getHeight(), build.getLength()};
    int[] order = {0,1,2};
    testNDS(new NDimensionalStepper(limits, order));
  }

  private void testBuild3(Build build) {
    System.out.println("Build: x--,y,z");
    for (int x = build.getWidth(); x > 0; x--) {
      for (int y = 0; y < build.getHeight(); y++) {
        for (int z = 0; z < build.getLength(); z++) {
          System.out.println("{" + x + "," + y + "," + z + "}");
        }
      }
    }
    int[] limits = {0, build.getHeight(), build.getLength()};
    int[] order = {2,1,0};
    int[] starts = {build.getWidth(), 0, 0};
    int[] steps = {-1, 1, 1};
    testNDS(new NDimensionalStepper(limits, order, starts, steps));
  }

  private void testNDS(NDimensionalStepper nds) {
    System.out.println("--nds--");
    do {
      System.out.println(nds);
    } while (nds.step());
  }