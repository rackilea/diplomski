while (input.hasNext()) {
        String word = input.next();
        Pattern pattern1 = Pattern.compile("Name:");
        Pattern pattern2 = Pattern.compile("Amount:");            
        Matcher matcher1 = pattern1.matcher(word);
        Matcher matcher2 = pattern2.matcher(word);
        if(matcher1.matches()){
            System.out.println(input.next());
        }
        if(matcher2.matches()){
            System.out.println(input.next());
        }           
    }