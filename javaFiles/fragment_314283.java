Map<String, Integer> mp = new TreeMap<>(new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
            return Integer.compare(Integer.valueOf(a.replaceAll("\\D+","")),
                    Integer.valueOf(b.replaceAll("\\D+","")));
        }
    });
    mp.put("abd10.9.0.9",6);
    mp.put("gbd17.0.6.2",65);
    mp.put("nmbd2.0.9.2",17);
    mp.put("klbd7.0.2.7",10);
    mp.put("rlbd8.1.2.8",10);
    mp.put("opbd9.0.2.3",9);
    mp.put("mpbd7.0.3.2",9);
    mp.put("wpbd7.0.7.0",9);