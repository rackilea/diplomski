String input = selectCol.next();
int colInput;

if (input.equals("quit"))
    Connect4.close();
else
 colInput = Integer.parseInt(input);
 //Use colInput here or return colInput or whatever you wish to do with it