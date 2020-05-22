Map<String, Integer> mp = new TreeMap<>(new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
            return Double.compare(Double.valueOf(a.replaceAll("[^\\d+(?:\\.\\d+)?]","")), 
                    Double.valueOf(b.replaceAll("[^\\d+(?:\\.\\d+)?]","")));
        }
    });
    mp.put("abd10.9",6);
    mp.put("abd17.02",65);
    mp.put("nmbd1.02",17);
    mp.put("klbd7.028",10);
    mp.put("klbd7.023",9);