for(int i=1;i<13;i++){ //This throws a NoSuchElementException if it's reading a savefile with empty TextAreas
         input[i] = (scan.hasNext())? scan.next(): "";
            }
            c1.setText(input[1]);
            c2.setText(input[2]);
            c3.setText(input[3]);
            c4.setText(input[4]);