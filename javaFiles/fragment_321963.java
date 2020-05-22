while (input.hasNextLine()) {
            String message = input.nextLine();
            String[] sentences = message.split("(?<=[.!?])\\s* ");
            List<String> shouldHaves = new ArrayList<String>();
                for (String s : sentences) {
                  if (s.contains("should have"))
                    shouldHaves.add(s);
                }
                for (String s : shouldHaves) {
                  System.out.println(s);
                }
        }