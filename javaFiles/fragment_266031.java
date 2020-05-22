String temp = "aaa\n123\nbbb\n124\ncccdef\n125\ndefg\n126";
        String parts[] = temp.split("\n");
        ArrayList<String> listItems = new ArrayList<String>();

        for (int i = 0; i < parts.length; i =i+2) {
            listItems.add(parts[i]+"\\n"+parts[i+1]);

        }
             /*Below loop is just to verify if your list contains correct items, Printing logs*/
        for (int i = 0; i < listItems.size(); i++) {

            Log.d("TEMP","item = "+ listItems.get(i));
        }