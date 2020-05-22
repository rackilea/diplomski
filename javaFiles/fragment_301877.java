String[] array = {"0 1 0 1", "0 0 1 1", "1 1 0 1"};
 List<String> answer = new ArrayList<String>();

 for (String str : array)
    for (String s : str.split(" "))
        answer.add(s);