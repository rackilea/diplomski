int s10 = 0, s40 = 0, s200 = 0, LL = 0, PI = 0;

        try{
        s10 = Integer.parseInt(S10.getText().toString());
        s40 = Integer.parseInt(S40.getText().toString());
        s200 = Integer.parseInt(S200.getText().toString());
        LL = Integer.parseInt(ll.getText().toString());
        PI = Integer.parseInt(pi.getText().toString());
        }
        catch(NumberFormatException e)
        {
          e.printStackTrace();
        }