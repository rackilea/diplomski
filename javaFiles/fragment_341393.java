String longestString = Collections.max(lst, new Comparator<String>() { //get length of longest word using Collections.max comparator
            @Override
            public int compare(String arg0, String arg1) {
                return arg0.length() - arg1.length();
            }
        });

int maxLength = longestString.length();