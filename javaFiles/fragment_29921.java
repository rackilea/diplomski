try {
            PDDocument doc = PDDocument.load(new File("E:\\project-test\\scloud\\test\\src\\main\\resources\\Shadip_Banik.pdf"));
            String text = new PDFTextStripper().getText(doc);

            sourceCode = text.replace("-", "").replace(".", "");


            String[] words = sourceCode.split(" ");

            amountOfWords = amountOfWords + words.length;
            StringBuilder builder = new StringBuilder();

            for (String word : words) {
                amountOfChars = amountOfChars + word.length();

                Pattern pattern = Pattern.compile("[a-zA-Z]");
                Matcher matcher = pattern.matcher(word);
                //System.out.println("MatchesCount "+matcher.group());
                while (matcher.find()) {
                    builder.append(matcher.group());

                }
            }
            String allData = builder.toString();
            System.out.println(builder.toString());
            int total = 0;
            for (int i=0;i<allAlphabate.length();i++)
            {
                int alphabateCount = 0;
                Pattern pattern = Pattern.compile(Character.toString(allAlphabate.charAt(i)));
                Matcher matcher = pattern.matcher(allData);
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
            System.out.println("Amount of Chars is " + amountOfChars);
            System.out.println("Amount of Words is " + (amountOfWords + 1));
            System.out.println("Average Word Length is " + (amountOfChars / amountOfWords));
        } catch (Exception ert) {

        }