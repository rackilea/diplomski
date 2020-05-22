List<String> list = Arrays.asList("1 hour","2 hours","1 hour 20 minutes","3 hours 30 minutes","3 hours 1 minute","1 hour 1 minute","1 minute","10 minutes");
Pattern p = Pattern.compile("^(?=.)(?:(?<hours>\\d+) *hours?)?(?: *(?<minutes>\\d+) *minutes?)?$");

list.stream().forEach(x -> {
    Matcher m = p.matcher(x);
    if (m.matches()) {
        System.out.println(x + " ----> Hours: " + m.group("hours") + ", Minutes: " + m.group("minutes"));
    } else {
        System.out.println(x + " ----> Didn't match");
    }
});