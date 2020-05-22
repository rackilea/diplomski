final String alphabet = "0123456789AaBbCcÇçDdEeFfGgĞğHhIıİiJjKkLlMmNnOoÖöPpQqRrSsŞşTtUuÜüVvWwXxYyZz";
SortedMap<String,String> map = new TreeMap(new Comparator<String>() {

        @Override
        public int compare(String o1, String o2) {
            int n = Math.min(o1.length(), o2.length());
            int i=0;
            while((i < n) && (o1.charAt(i) == o2.charAt(i))){
                i++;
            }
            if(i==n){
                return 0;
            }
            if(alphabet.indexOf(o1.charAt(i)) < alphabet.indexOf(o2.charAt(i))){
                return -1;
            }
            return 1;
        }
    });