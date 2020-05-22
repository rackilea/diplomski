public class xx {
    public static void main(String args[]) {
        String idCode = "CT";
        String input = "fgdfgdg CT: (2.57)";

        System.out.println ("input  = [" + input + "]");
        System.out.println ("idCode = [" + idCode + "]");

        int i1 = input.indexOf(idCode);
        System.out.println ("offst1 = [" + i1 + "]");

        int i2 = input.indexOf("(",i1);
        System.out.println ("offst2 = [" + i2 + "]");

        int i3 = input.indexOf(")",i1);
        System.out.println ("offst3 = [" + i3 + "]");

        String s1 = input.substring(i2+1,i3);
        System.out.println ("strng1 = [" + s1 + "]");

        float f1 = Float.parseFloat(s1);
        System.out.println ("float1 = [" + f1 + "]");

        System.out.println ("full   = [" + Float.parseFloat( input.substring( 
            input.indexOf( "(", input.indexOf( idCode ) ) + 1, 
            input.indexOf( ")", input.indexOf( idCode ) ) )) + "]");
    }
}