String[] array = new String[3];
    array[0] = "<a href=\"/item/main.nhn?code=002530\" class=\"tltle\">Marine</a>";
    array[1] = "<a href=\"/item/main.nhn?code=068270\" class=\"tltle\">Medic</a>";
    array[2] = "<a href=\"/item/main.nhn?code=053800\" class=\"tltle\">Firebat</a>";

    Pattern pattern = Pattern.compile(".*code=([0-9]*).*>([A-Za-z]*)<.*");

    for (int i = 0; i < array.length; i++) {
        String string = array[i];
        Matcher ma = pattern.matcher(string);
        System.out.println("Code " + i + ":" + ma.replaceFirst("$1"));
        System.out.println("Text " + i + ":" + ma.replaceFirst("$2"));
    }