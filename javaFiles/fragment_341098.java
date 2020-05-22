public static boolean hasDuplicates() {
        List<Integer> forbiddenValues = Arrays.asList(1, 2, 3);

        List<MyPojo> pojoList = Arrays.asList(new MyPojo(0), new MyPojo(2),
                new MyPojo(2), new MyPojo(3), new MyPojo(3), new MyPojo(4));


        Map<Integer, Integer> counts = new HashMap<>();

        for(int forbidden : forbiddenValues){
            counts.put(forbidden, 0);
        }

        for(MyPojo myPojo : pojoList){
            if(counts.containsKey(myPojo.getValue())){
                int count = counts.get(myPojo.getValue());

                if(count == 1){
                    return true;
                }

                counts.put(myPojo.getValue(), count + 1);
            }
        }

        return false;
    }