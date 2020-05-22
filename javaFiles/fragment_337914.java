String sData = "abc|def|\"de|er\"|123";
    String[] aSplit = sData.split("\\|");

        for(int i = 0; i < aSplit.length; i++) {
            if(aSplit[i].startsWith("\"")) {
                if(aSplit[i+1].endsWith("\"")) {
                    aSplit[i] = aSplit[i] + "|" + aSplit[i+1];
                    aSplit[i+1] = "";
                }
            }
        }

    for(String s : aSplit) {
        if(!s.equals(""))
        System.out.println(s);
    }