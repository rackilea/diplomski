private static final int INPUT_CONDITION = JComponent.WHEN_IN_FOCUSED_WINDOW;
   private int height;
   private int width;
   //...

   public Rectangle(int width, int height, int x, int y) {
      // .....

      up = new UpAction();

      // ******** note difference to the getInputMap method below
      getInputMap(INPUT_CONDITION).put(KeyStroke.getKeyStroke("UP"),
            "doUpAction");
      getActionMap().put("doUpAction", up);
      plusAction = new PlusAction();
      minusAction = new MinusAction();
      buttonIncrease.getInputMap(INPUT_CONDITION).put(
            KeyStroke.getKeyStroke("released Q"), "doPlusAction");
      buttonIncrease.getActionMap().put("doPlusAction", plusAction);
      buttonDecrease.getInputMap(INPUT_CONDITION).put(
            KeyStroke.getKeyStroke("released A"), "doMinusAction");