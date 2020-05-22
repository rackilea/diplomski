Collections.sort(powerSet, new Comparator<List<Integer>>() {

        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            StringBuilder temp = new StringBuilder();
            StringBuilder temp2 = new StringBuilder();
            for (Integer i2 : o1) {
                temp.append( i2 );
            }
            for (Integer i2 : o2) {
                temp2.append( i2 );
            }

            if(temp.length() == temp2.length())
                return Integer.parseInt(temp.toString()) - Integer.parseInt(temp2.toString());
            else
                return temp.length() - temp2.length();
        }
    });