Arrays.sort(scoreboard, new Comparator<String[]>() {
     @Override
     public int compare(String[] entry1, String[] entry2) {
        Integer time1 = Integer.valueOf(entry1[1]);
        Integer time2 = Integer.valueOf(entry2[1]);
        return time1.compareTo(time2);
        }
     });