uiStage.addListener(new ClickListener()
    {
        @Override
        public boolean keyDown(InputEvent event, int keycode)
        {
            System.out.println(keycode);
            return true;
        }
    });