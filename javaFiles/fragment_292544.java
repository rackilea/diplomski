int count = 0;
        for (int h = 0; h < array[f][g].length; h++) {
            if (array[f][g][h].equals(array[f][g][h+1])) count++;
            //You dont check for out of bound here, so `h + 1` will cause out of bound error
            else {
                ArrayList<String> temp = new ArrayList<String>(Arrays.asList(array[f][g]));
                for (int i = count - 1; i > position; i--) {
                    temp.remove(i);
                    position = i-1 ;
                }
                temp.set(position, array[f][g][h] + " (" + count + ")");
            }
            //Count is not reset after this, so this will be wrong!
        }