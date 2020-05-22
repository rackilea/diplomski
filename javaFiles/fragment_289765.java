String value = "\\/Date(1440959400000+0530)\\/";
    int start = value.indexOf("(");
    int last = value.lastIndexOf("0");
    value = value.substring(start + 1, last + 1);
    System.out.println(value); <--- 1440959400000+0530

    DataUtil.getDateForUnixDate(value);