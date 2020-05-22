case 0:{
            if(filled[0] != true){
                array[x][y] = words[0];
                counter[0]++;
                x++;
                if(x == array.length){
                    y++;
                    x = 0;
                }
            }
            break;
        }