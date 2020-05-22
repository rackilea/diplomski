@XStreamAlias("listZakazniku")
public class ListZakazniku {

    private List<Zakaznik> zakaznicis;

    public ListZakazniku() {
        zakaznicis = new ArrayList<Zakaznik>();
    }

    public void add(Zakaznik user) {
        zakaznicis.add(user);
    }


    @XStreamAlias("zakaznik")
    private static class Zakaznik {
        private String user;
        private String pwd;
        public Zakaznik(String user, String pwd) {
            this.user = user;
            this.pwd = pwd;
        }
    }


    public static void main(String[] args){
        XStream xstream = new XStream();
        xstream.processAnnotations(ListZakazniku.class);
        ListZakazniku ll = new ListZakazniku();
        ll.add(new Zakaznik("user1", "pwd1"));
        ll.add(new Zakaznik("user2", "pwd2"));
        try {
            try (PrintWriter out = new PrintWriter("Zakaznici.xml")) {
                out.println(xstream.toXML(ll));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}