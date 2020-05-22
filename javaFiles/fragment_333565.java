String text = "where create_dtm between (select start_dtm FROM schema.table where table_ID = (SELECT MAX(table_ID) FROM schema.table WHERE MAINT_APP = 'JOB01'))"
                + "and (select end_dtm FROM schema.tablewhere table_ID = (SELECT MAX(table_ID) "
                + "FROM schema.table WHERE MAINT_APP = 'JOB01')) ";

        Pattern p = Pattern.compile(
                "where[\\w*\\s*]*\\(\\s*(select[\\w*\\s*\\.*=*\\(\\)\\']*)\\s*and\\s*\\(\\s*(select[\\w*\\s*\\.*=*\\(\\)\\']*)\\s");
        Matcher m = p.matcher(text);
        if (m.matches()) {
            String group1 = m.group(1);
            String group2 = m.group(2);
            System.out.println(group1+"\n"+ group2);
        }