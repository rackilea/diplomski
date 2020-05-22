private static String ascending(String s) 
    {
        char[] asc = s.toCharArray();
        Arrays.sort(asc);
        String sorted = new String(asc);
        return sorted;
    }