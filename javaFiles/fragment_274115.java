public String[] process() throws Exception {
        String[] ret = new String[20];

        Map<String, Integer> map = new HashMap<String, Integer>();
        FileReader in = new FileReader(inputFileName);
        BufferedReader br = new BufferedReader(in);
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, delimiters + " ");

            while (st.hasMoreTokens()) {
                String token = st.nextToken().toLowerCase();
                if (!Arrays.asList(stopWordsArray).contains(token))
                    if (map.containsKey(token)) {
                        map.put(token, map.get(token) + 1);
                    } else
                        map.put(token, 1);
                    }
        }
        br.close();
        for(int i=0;i<ret.length;i++){
            int max=0;
            String word="";
            for(Entry<String,Integer> entry:map.entrySet()){
                if(entry.getValue()>max){
                    max=entry.getValue();
                    word=entry.getKey();
                }
            }
            map.remove(word);
            ret[i]=word;
        }

        return ret;
    }