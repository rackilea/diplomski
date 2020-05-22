void getJsonFromString(String input) {

        List<Character> stack = new ArrayList<Character>();
        List<String> jsons = new ArrayList<String>();
        String temp = "";
        for(char eachChar: input.toCharArray()) {
            if(stack.isEmpty() && eachChar == '{') {
                stack.add(eachChar);
                temp += eachChar;
            } else if(!stack.isEmpty()) {
                temp += eachChar;
                if(stack.get(stack.size()-1).equals('{') && eachChar == '}') {
                    stack.remove(stack.size()-1);
                    if(stack.isEmpty()) {
                        jsons.add(temp);
                        temp = "";
                    }
                }
                else if(eachChar == '{' || eachChar == '}')
                    stack.add(eachChar);
            } else if(temp.length()>0 && stack.isEmpty()) {
                jsons.add(temp);
                temp = "";
            }
        }
        for(String json: jsons)
            System.out.println(json);
    }