for (String s : new String[] {
            // Even strings
            "FFHHIIJJ", "UUURROOOR", "HHEEPPDIDI", "LLLQQMQMM", "abaccb", "abc", "d", "",
            // Odd strings
            "IIREELO", "PPGIUUUUS", "HRTRDFF", "HIYUDHDA", "abbc", "aabcc" }) {
        System.out.format("%-11s %b%n", s, isEven(s));
    }