public static void main(String[] args) {

        String data="ABC,  DAY 1/2, DAY 1/1, DAY 1/16, DAY 1/2, day 1/1, day 1/52, day 1/32";
        String [] list=data.split(",");
        List<String> llist=new ArrayList<>();
        for (String string : list) {
            llist.add(string);
        }
        Collections.sort(llist,new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {

                if(o1.contains("DAY 1/") && o2.contains("DAY 1/")){
                    String s1=o1.split("/")[1];
                    String s2=o2.split("/")[1];
                   return Integer.parseInt(s1)>Integer.parseInt(s2)?1:-1;
                }else{
                    return o1.trim().compareTo(o2.trim());
                }

            }


        });

        System.out.println(llist);
}