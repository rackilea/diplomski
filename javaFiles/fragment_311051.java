import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        String hex1 = "0xf27f2029f9c103f77be78b9591c1ab27167858d27d789cd3ea8a270c67ea5d91";
        String hex2 = "0x1";
        System.out.println(
                "In decimal: " + new BigInteger(hex1.substring(2), 16).add(new BigInteger(hex2.substring(2), 16)));
        System.out.println("In hexdecimal: "
                + new BigInteger(hex1.substring(2), 16).add(new BigInteger(hex2.substring(2), 16)).toString(16));
    }
}