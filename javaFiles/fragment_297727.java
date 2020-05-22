Comparator<Item> ignoreLeadingThe = new Comparator<Item>() {
        Pattern pattern = Pattern.compile("(?i)^the\\s+");
        public int compare(Item a, Item b) {
            String newA = pattern.matcher(a.name).replaceAll("");
            String newB = pattern.matcher(b.name).replaceAll("");
            return newA.compareToIgnoreCase(newB);
        }
    };