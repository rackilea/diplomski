@Test
        public void regex() {
            String str = "Nom for 3 Oscar, dom for 234235 Oscars";
            Pattern pattern = Pattern.compile("for(.*?)Oscar");
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                System.out.println(matcher.group(1));
            }
        }