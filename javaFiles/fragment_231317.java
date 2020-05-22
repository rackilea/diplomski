public static String[] listToArray(List<Object[]> inputList) {
        List<String> outputList = new ArrayList<String>();
        for(Object[] obj : inputList) {
            for(Object obj1 : obj)
            {
                outputList.add((String) obj1);
            }
        }
        return outputList.toArray(new String[outputList.size()]);
    }