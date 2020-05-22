String str = "abc |Bill Purchase / Discounting (Inland)-amount xyz";

    Pattern patter = Pattern.compile("(\\|(.*)-amount|\\|PARTNER_NAME-PAN)");
    Matcher matcher = patter.matcher(str);

    if (matcher.find()) {
        System.out.println("accept");
        System.out.println(matcher.group());
    }