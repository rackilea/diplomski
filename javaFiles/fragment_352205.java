for (int i = 0; i < game.length; i++ ){

        char[] temp = new char[game.length];
        copyArray(temp, game);

        if (i-2 >= 0 && temp[i] == '-' && temp[i-2] == 'o' && temp[i-1] == 'o'){//move pebble forwards
            temp[i-1] = temp[i-2] = '-'; 
            temp[i] = 'o';
            result = Math.min(result, solve(temp));
        }

        copyArray(temp, game);

        if(i+2 < temp.length && temp[i] == '-' && temp[i+1] == 'o' && temp[i+2] == 'o'){//move pebble backwards
            temp[i+1] = temp[i+2] = '-';
            temp[i] = 'o';
            result = Math.min(result, solve(temp));
        }
    }