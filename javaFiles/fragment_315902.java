String[] html = new String[] { 
                "<div id=\"option1\">hello</div>",
                "<div style=\"color: cyan\">world</div>" };

        String tag = "div";
        Pattern p = Pattern.compile("<" + tag + ".*?>(.*?)</" + tag + ">");
        Matcher m;

        for(String index : html){
            m = p.matcher(index);
            while(m.find()) System.out.println(m.group(1));
        }