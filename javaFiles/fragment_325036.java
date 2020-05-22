You can use the following logic ....   
List<String> lines = Files.readAllLines(FileSystems.getDefault()
                    .getPath("yourhtmlfile"),
                    StandardCharsets.UTF_8);    
            for (String htmlData : lines)
            {
                Pattern splitPattern = Pattern
                        .compile(sometext_pattern);
                Matcher match = splitPattern.matcher(htmlData);

                while (match.find())
                {    
                    String lineToBeSplit = match.group();    

                }

                            .
                            .

            }

"lineToBeSplit" will have the split data.