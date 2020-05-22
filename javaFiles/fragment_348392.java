while(currentSquare<81){
            rand = rn.nextInt(availableNumbers.size());
            number = availableNumbers.get(rand);
            if(square[currentSquare].contains(number)){
                square[currentSquare].remove(new Integer(number));
                if(!checkConflict(number)){
                    squares[y][x].setText(""+number);
                    addedNumbers[y][x] = number;
                    availableNumbers.remove(rand);
                    moveAhead();
                    currentSquare++;
                }
            }
            if(currentSquare < 81){
                while(square[currentSquare].isEmpty()){
                    square[currentSquare].addAll(refList);
                    addedNumbers[y][x] = 0;
                    availableNumbers.addAll(refList);
                    moveBack();
                    if(currentSquare>=1){
                        currentSquare--;
                    }
                }
            }
        }