String regex = ".*?[^:]DB\\((.*?)\\).*?";
    String string = "{'Opening Cost P&L per store','Opening Costs Capital per store','Average Monthly Revenue','GROSS MARGIN %'}] = N:DB('Store Cost', \n"
            + "    !Country and Region, DB('New Store Plan', !Country and Region, \n"
            + "    !ID numbers, !Budget version, 'Retailer Type'), ATTRS('New Stores', \n"
            + "    !New Stores, '}Map_}Link_New Store Plan_3CStore Cost'), DB('New Store Plan', \n"
            + "    !Country and Region, !ID numbers, !Budget version, 'Size'), \n"
            + "    DB('New Store Plan', !Country and Region, !ID numbers, !Budget version, \n" + "    'Franchise/Corporate'), 'DATA')";

    Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.DOTALL);
    Matcher matcher = pattern.matcher(string);

    while (matcher.find()) {
        System.out.println("> " + matcher.group(1));
    }