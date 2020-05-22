String input = "My name is #George and I like #Java.";
             Pattern patt = Pattern.compile("(#\\w+)\\b");
             Matcher match = patt.matcher(input);
             List<String> matStr =new ArrayList<String>();
             while (match.find()) {
                 matStr.add(match.group(1));
            }
                 System.out.println("Results are: "+matStr.get(0)+" , " +matStr.get(1));