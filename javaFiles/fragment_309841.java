Comparator<List<String>> c = (l1, l2) -> {
            Collections.sort(l1); // elements to be sorted
            Collections.sort(l2); // elements to be sorted
            int in = l1.get(0).length() - l2.get(0).length();
            if (in == 0) {
                return String.join(" ", l1).compareTo(String.join(" ", l2));
            } else {
                return in;
            }
        };