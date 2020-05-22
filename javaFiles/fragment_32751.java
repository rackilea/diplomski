String s = "Minimum: 672ms, Maximum: 696ms,...time=675ms ... ";
    // the following code will match the first two numbers but not the third! 
    Pattern p = Pattern.compile("\\s\\d+ms");
    Matcher m = p.matcher(s);
    while(m.find()) {
        System.out.println(m.group().trim());
    }