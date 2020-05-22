LinkedList<String> list = new LinkedList<String>();

list.add("TY12354d,sfasdf,asfasf,2.35123412E8");
list.add("TY12354dsaf,asdffasd,asfasfafsd,12344.0");
list.add("Pranish,pranishfilan,viper,1234");
list.add("zxs,asdf,asfd,1234");
list.add("uv,vr,va,1234");
list.add("www,dsf,ASDF,123");
list.add("dsfgsdf,sd,sd,235");

Collections.sort(list, new Comparator<String>() {
    public int compare(String a, String b) {
        System.out.println(a+" --> "+b);
        return a.substring(0, a.indexOf(',')).compareTo(b.substring(0, b.indexOf(',')));
    }
});