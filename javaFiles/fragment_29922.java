for (String word : words) {
                    amountOfChars = amountOfChars + word.length();

                    Pattern pattern = Pattern.compile("[a-zA-Z]");
                    Matcher matcher = pattern.matcher(word.toLowerCase());
                    //System.out.println("MatchesCount "+matcher.group());
                    while (matcher.find()) {
                        builder.append(matcher.group());

                    }
                }
                String allData = builder.toString();
                int total = 0;
                for (int i=0;i<allAlphabate.length();i++)
                {
                    int alphabateCount = 0;
                    Pattern pattern = Pattern.compile(Character.toString(allAlphabate.charAt(i)));
                    Matcher matcher = pattern.matcher(allData.toLowerCase());
                    while (matcher.find()) {
                        alphabateCount++;
                    }
                    total+=alphabateCount;
                    System.out.println(allAlphabate.charAt(i) +" : "+alphabateCount);
                }
                if(total == builder.toString().length())
                {
                    System.out.println("Yes   -------------------------------------------------");
}