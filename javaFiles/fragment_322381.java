public static List<Integer> extractNumbers(String s){       
        List<Integer> numbers = new ArrayList<Integer>();

        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(s);

        while(m.find()){
            numbers.add(Integer.parseInt(m.group()));
        }       
        return numbers;     
    }