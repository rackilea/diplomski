static List<String> query(String queryStr, List<Student> list) {
        List<String> suggestion = new ArrayList<>();
        list.forEach(std -> {
            if (isMatched(queryStr, String.valueOf(std.getRoll()))) {
                suggestion.add(String.valueOf(std.getRoll()));
            }

            if (isMatched(queryStr, std.getName())) {
                suggestion.add(std.getName());
            }

            if (isMatched(queryStr, std.getAddress())) {
                suggestion.add(std.getAddress());
            }
        });

        return suggestion;
    }

    private static boolean isMatched(String query, String text) {
        return text.toLowerCase().contains(query.toLowerCase());
    }