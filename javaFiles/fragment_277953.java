String str = "[342398789], [233434] ,423545(50),[7568787(500)],"
        + "53654656,2021947(50),[021947],2021947(150),[8021947(50)]";
String[] listItems = str.replaceFirst("^\\[", "").split(
        "(\\(\\d+\\))?\\]?(\\s*,\\s*\\[?|$)");

System.out.println(Arrays.toString(listItems));