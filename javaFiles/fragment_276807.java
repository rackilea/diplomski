String str = "insert into table \n"
            + "values (‘test’,\n"
            + "<xml> \n"
            + "</xml>);\n"
            + "insert into table \n"
            + "values (‘test’,\n"
            + "<xml> \n"
            + "<xml>\n"
            + "<xml>\n"
            + "</xml>);\n"
            + "insert into table \n"
            + "values (‘test’,\n"
            + "<xml> \n"
            + "<xml>\n"
            + "<xml>\n"
            + "<xml>\n"
            + "<xml>\n"
            + "</xml>);";

    String[] commands = str.split(";");
    for(String command : commands)
    {
        System.out.println(command + ";");
    }