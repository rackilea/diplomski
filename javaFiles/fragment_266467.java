for(int row = 0; row < newArray.length; row++){
        for(int col = 0; col < newArray[row].length; col++){
            for(int line = 1; line < list.size(); line++){
                for(int Char = 0; Char < list.get(line).length(); Char++){
                    newArray[row][col] = list.get(line).charAt(Char);
                }
            }
        }
    }