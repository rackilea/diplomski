String s = "Interest\n"
            + "Unknown Unknown’s \n"
            + "I do not own or know of any assets that should be listed in this category.\n"
            + "$125\n"
            + "Net value of all Home property (Schedules A through H)\n"
            + "$128\n"
            + "Net value of all Bank property (Schedule I)\n"
            + "$253\n"
            + "Net value of all property (Schedules A through I)";
    Pattern p = Pattern.compile("(?<=\\$)\\d+");
    Matcher m = p.matcher(s);
    while (m.find()) {
        System.out.println(m.group());
    }