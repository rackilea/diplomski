String str = "{1 2 3{4 5 6{7 8 9}10 11}12 13 14}";
    StringBuilder res = new StringBuilder();
    Stack<StringBuilder> temp = new Stack<>();
    for(char c : str.toCharArray()){
        switch(c){
            case '{':
                if(!temp.isEmpty())temp.peek().append(",");
                temp.push(new StringBuilder());
                break;
            case '}':
                if(!temp.isEmpty())temp.peek().append(",");
                res.insert(0,temp.pop());
                break;
            case ' ':
                temp.peek().append(",");
                break;
            default:
                temp.peek().append(c);
        }

    }

    System.out.println(res); //1,2,3,12,13,14,4,5,6,10,11,7,8,9,