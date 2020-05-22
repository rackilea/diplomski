public static int calculatePoints(ArrayList<Integer> dice) {
        int max = 0;
        for(Integer die : dice) {
            int temp = Collections.frequency(dice, die);
            if(temp > max) {
                max = temp;
            }
        }
        if(max >= 6) {
            //Do stuff
        } else if (max >=5) {
            //Do stuff
        } else if (max >= 4) {
            //Do stuff
        }        
        return 0;
    }