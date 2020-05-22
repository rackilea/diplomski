String[] books = {
            "The Great Gatsby",
            "The Witches",
            "Persuasion",
            "It",
            "Therapy"};
Arrays.sort(books,
            Comparator.comparing(b -> b.length() >= 4 && b.substring(0, 4).equalsIgnoreCase("the ") ? b.substring(4) : b,
                    String.CASE_INSENSITIVE_ORDER));
System.out.println(Arrays.toString(books));