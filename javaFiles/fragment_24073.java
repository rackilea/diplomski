public static void main(String[] args) {
        String[] values ={"eat", "tea", "tan", "ate", "nat", "bat"};
        Map<Integer, List<String>> resultMap = new HashMap<Integer, List<String>>();
        for (String value : values) {
            char[] caharacters = value.toLowerCase().toCharArray();
            int asciSum = 0;
            for (char character : caharacters) {
                asciSum = asciSum + (int)character;
            }
            System.out.println(asciSum);
            if(resultMap.containsKey(asciSum)) {
                resultMap.get(asciSum).add(value);
            }else {
                List<String> list = new ArrayList<String>();
                list.add(value);
                resultMap.put(asciSum, list);
            }
        }
        System.out.println(resultMap);
    }