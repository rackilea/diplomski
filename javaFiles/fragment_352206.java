for (int i = 0; i < game.length; i++ ){
        char[] temp = null;

        if (i-2 >= 0 && game[i] == '-' && game[i-2] == 'o' && game[i-1] == 'o'){//move pebble forwards
            temp = new char[game.length];
            copyArray(temp, game);
            temp[i-1] = temp[i-2] = '-'; 
            temp[i] = 'o';
            result = Math.min(result, solve(temp));
        }



        if(i+2 < game.length && game[i] == '-' && game[i+1] == 'o' && game[i+2] == 'o'){//move pebble backwards

            if(temp == null) temp = new char[game.length];             

            copyArray(temp, game);
            temp[i+1] = temp[i+2] = '-';
            temp[i] = 'o';
            result = Math.min(result, solve(temp));
        }
    }