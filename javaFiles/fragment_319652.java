Pattern pattern = Pattern.compile("\\[[^\\[.]+?\\]");

        String str = "dt = (double[]) obj[i];";

        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }