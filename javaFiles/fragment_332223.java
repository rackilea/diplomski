public class B {

    public static void main(String[] args) {

        String number = "126";
        int c = 1;
        for (int j =  number.length() ; j >=0; j--) {
        int v = j;
            for (int i = 0; i < v; i++) {
                String s = ""+number.charAt(i);
                c = c*  Integer.parseInt(s.trim());
            }

            System.out.println("result is : "+c);    
            c = 1;
        }        
}
}