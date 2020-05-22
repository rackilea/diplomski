public static void main(String[] args) {
        String json = "[\"a,rt\", \"der\", \"a_rt5%\"]";
        JSONArray jsonArray = new JSONArray(json);
        List<String> list = new ArrayList<String>();
        for (int i=0; i<jsonArray.length(); i++) {
            list.add( jsonArray.getString(i) );
        }

        System.out.println(list);
    }