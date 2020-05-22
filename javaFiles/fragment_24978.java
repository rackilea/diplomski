public class Main { 
    public static void main(String[] args) {
        String line = "foo,bar,c;qual=\"baz,blurb\",d;junk=\"quux,syzygy\"";
        String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        for(String t : tokens) {
            System.out.println("> "+t);
        }
    }
}