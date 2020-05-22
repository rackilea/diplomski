for(String item : items)
    {
        if(input.equals("get " + item));
        {
            items.remove(item);
            gameScreen.append("\nYou pick up the " + item);
            invScreen.append("\n" + item);
            playerInput.setText("");
        }
    }