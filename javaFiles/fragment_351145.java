List<String> matchList = new ArrayList<String>();
        Pattern regex = Pattern.compile("acquireTest\\((.*?)\\)");
        Matcher regexMatcher = regex.matcher("format.getControl(val.acquireTest(xyzTest));\\n");

        while (regexMatcher.find()) {
           matchList.add(regexMatcher.group(1));
        }

        for(String str:matchList) {
           System.out.println(str);
        }