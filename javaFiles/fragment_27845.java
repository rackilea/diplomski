public class Dublicate{
    public static void main(String[] args){
        if (args.length > 0) {
           int r=0;
           for (int i = 0; i < args[0].length(); ++i) { 
                char ch=args[0].charAt(i);
                r=r*10+ch-'0';
            }
            System.out.println(r);
        }
    }
}