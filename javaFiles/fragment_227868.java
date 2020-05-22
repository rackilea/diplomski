String regex = "(\\d*):(\\d*)";
    Pattern checkInput = Pattern.compile(regex);

    Matcher matcherInput = checkInput.matcher(range);

    if(matcherInput.matches()){
        rangeResults[1] = Integer.parseInt(matcherInput.group(1));
        rangeResults[2] = Integer.parseInt(matcherInput.group(2));



    }