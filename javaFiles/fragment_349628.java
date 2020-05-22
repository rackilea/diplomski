String input = "test 7 speed,7,red,fast yup 7 tr";
    int indexInteresdIn = 13;
    if(input.charAt(indexInteresdIn) == '7'){
        StringBuilder builder = new StringBuilder(input);
        builder.replace(indexInteresdIn, indexInteresdIn+1, "Seven");
        System.out.println(builder.toString());
    }