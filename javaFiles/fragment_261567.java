public static void main(String[] args) {
        String[] s = {"a    101","[newline]      111"};
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<s.length;i++) {
            String[] splitedData = s[i].split("\\s+");
            map.put(splitedData[0], Integer.valueOf(splitedData[1].trim()));
        }
        for (Map.Entry<String,Integer> entry : map.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }