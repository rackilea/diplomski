String in = "B*A'*D*H'";
    String[] vars = in.split("\\*");

    Arrays.sort(vars);

    // Java is missing a simple php-like join function ;-(
    StringBuilder sorted = new StringBuilder();
    for(String s: vars){
        sorted.append(s);
        sorted.append("*");
    }
    sorted.deleteCharAt(sorted.length()-1);