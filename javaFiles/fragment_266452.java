private static boolean check(String string){
        Queue<Character> chars = new LinkedList<>();
        for (Character charr: string.toCharArray()){
            if (charr.equals('{') || charr.equals('[') || charr.equals('(')){
                chars.add(charr);
            }else if (charr.equals('}') && chars.getLast().equals('{')){
                chars.pollLast();
            }else if (charr.equals(')') && chars.getLast().equals('(')){
                chars.pollLast();
            }else if (charr.equals(']') && chars.getLast().equals('[')){
                chars.pollLast();
            }
        }
        return chars.isEmpty();
    }