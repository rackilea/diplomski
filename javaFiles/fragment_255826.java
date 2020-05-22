String[] as = { "california1", "california2_scenes", "california11", "california12_people", "utah8",
            "utah3_tounament" };
    for (String s : as) {
        //no number behind, number, no number ahead
        String sp = "(?<!\\d)\\d(?!\\d)";
        Pattern p = Pattern.compile(sp);
        System.out.println(s);
        System.out.println(s.replaceAll(sp, "0$0"));
    }