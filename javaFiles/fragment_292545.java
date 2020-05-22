ArrayList<String> tmp  = new ArrayList<>();
        for (int h = 0; h < array[f][g].length; h++) {
            int count = 1;
            while(h + count < array[f][g].length && array[f][g][h].equals(array[f][g][h+count])) 
               count++;
            tmp.add(array[f][g][h] + "(" + count + ")");
            h += count - 1;//Update h to skip identical element
        }