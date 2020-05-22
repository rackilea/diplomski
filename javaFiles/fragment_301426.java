String inputStr = "[\"A\",\"B\",\"0\",\"1\"]";
        String[] strArray = inputStr.split("[^\\w\\d]");
        List<String> list = new ArrayList<>();
        for (String str : strArray) {
            if (str != null && !str.isEmpty()) {
                list.add(str);
            }
        }
System.out.println(list);