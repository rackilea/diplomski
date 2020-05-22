public static void printFrequency(String[] totalterms)
{
    Map frequencyMap = new HashMap<String, Integer>();

    for (String string : totalterms) {
        if(frequencyMap.containsKey(string))
        {
            Integer count = (Integer)frequencyMap.get(string);
            frequencyMap.put(string, count+1);
        }
        else
        {
            frequencyMap.put(string, 1);
        }
    }

    Set <Entry<String, Integer>> elements= frequencyMap.entrySet();

    for (Entry<String, Integer> entry : elements) {
        System.out.println(entry.getKey()+"|"+entry.getValue());
    }
}