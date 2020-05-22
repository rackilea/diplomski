public class Main {
    public static void main(String[] args){
        int i = 0;
        String regex = "&{token1}&{token2}&{tokenN}\n" +
                "&{token1&{token2&{tokenN}}}\n" +
                "text{1,2}&{token1{1}&{token2{1,}&{tokenN{0,2}}}}\n";
        regex = regex.replaceAll("(?<=&)(?=\\{)|(?<!\\{\\d{0,6},?(\\d{0,6})?)(?=\\})","\\\\");
        System.out.println(regex);
    }
}