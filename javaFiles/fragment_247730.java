Collections.sort(listOfRecords, new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                //null checks

                /*Compare the object field according to your custom logic. 
                 Here it is assumed that getObjectCodeAsInt() will return an integer equivalent of the objectCode.*/
                if(o1.getObjectCodeAsInt() > o2.getObjectCodeAsInt())
                    return 1;
                else if(o1.getObjectCodeAsInt() < o2.getObjectCodeAsInt())
                    return -1;

                return 0;
            }
        });