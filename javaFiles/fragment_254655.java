Iterator<String> iter = items.iterator();

while (iter.hasNext()) {
    String str = iter.next();

   if(input.equals("get " + str))
        {
        iter.remove();
        gameScreen.append("\nYou pick up the " + str);
        invScreen.append("\n" + str);
        playerInput.setText("");
        }

}