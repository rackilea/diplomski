int intValuesMarks;
        ArrayList<Integer>arrValueList = new ArrayList<Integer>();
        String str[]=AllMarks.getText().split("\\s+");//created a string array , each element in the array is the marks.
        for (String string : str) {
            intValuesMarks = Integer.parseInt(string);
            arrValueList.add(intValuesMarks);


        }

         Collections.sort(arrValueList);
         AllMarks.setText("" + arrValueList);