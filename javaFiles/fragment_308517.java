table.setSelectable(true);
    table.addShortcutListener(new ShortcutListener("", KeyCode.DELETE, new int[10])
    {

        @Override
        public void handleAction(Object sender, Object target)
        {
            table.getValue(); //returns selected rows
            if (getKeyCode() == KeyCode.DELETE)
            {
                System.out.println("Merry Christmas");
            }
        }
    });