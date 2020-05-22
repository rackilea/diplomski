public static void main(String[] args) {
        String[] values ={"eat", "tea", "tan", "ate", "nat", "bat"};
        Map<String, List<String>> resultMap = new HashMap<String, List<String>>();
        for (String value : values) {
            char[] caharacters = value.toLowerCase().toCharArray();
            Arrays.sort(caharacters);
            String sortedValue = new String(caharacters);
            System.out.println(sortedValue);
            if(resultMap.containsKey(sortedValue)) {
                resultMap.get(sortedValue).add(value);
            }else {
                List<String> list = new ArrayList<String>();
                list.add(value);
                resultMap.put(sortedValue, list);
            }
        }
        System.out.println(resultMap);
    }