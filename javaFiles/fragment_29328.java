public class Main {
    public static void main(String[] args) {
        System.out.println(getsequencenumber("Bladds seq 1910428391283 ldskgj"));
    }

    public static long getsequencenumber(String Packet){
        Pattern P = Pattern.compile("seq.(\\d*)"); 
        Matcher m = P.matcher(Packet);
        if(m.find()){
            return Long.valueOf(m.group(1));
        }
        return -1;
    }
}