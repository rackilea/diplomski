Long mil = 0L;
    Matcher matcher = Pattern.compile("\\d+\\D+").matcher(time);
    while (matcher.find()) {
        String s = matcher.group();
        Long numb = Long.parseLong(s.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)")[0]);
        String type = s.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)")[1];
        switch(type){
        case "s":
            mil = mil + (numb); break;
        case "m":
            mil = mil + (numb * 60); break;
        case "h":
            mil = mil + (numb * 60 * 60); break;
        case "d":
            mil = mil + (numb * 60 * 60 * 24); break;
        case "w":
            mil = mil + (numb * 60 * 60 * 24 * 7); break;
        case "M":
            mil = mil + (numb * 60 * 60 * 24 * 30); break;
        case "y":
            mil = mil + (numb * 60 * 60 * 24 * 365); break;
        }
    }