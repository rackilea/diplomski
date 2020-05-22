public class Goran {

    public static void main(String[] args) {
        String brand;
        String name;

        //i named my class "Goran" ;)
        Goran goran = new Goran(); //instatiate a class object

        String hello = "hello world";

        System.out.println(goran.rovarSpraket(hello)); //use class object method "roverSpraket"

        brand = "Saab";
        name = "henry";

        if (brand.equals("Saab") || brand.equals("Volvo")){
            name = goran.rovarSpraket(name); //translate if brand is Saab or Volvo
        }

        System.out.println("new name is " + name);

    }

    public String rovarSpraket(String normalString) {

        final String consonantsx = "bBcCdDeEfFgGhHjJkKlLmMnNpPqQrRsStTvVwWxXzZ"; 
        char consonants[] = consonantsx.toCharArray(); // String to charr

        int length = normalString.length(); // Length inc. space
        char array[] = normalString.toCharArray(); // Input to a char array

        String slang = "";
        System.out.println("På rövarspråk:");
        for (int i = 0; i < length; i++) {
            for (int x = 0; x < 20; x++) {
                if (array[i] == consonants[x]) {
                    String add = array[i] + "o" + array[i];
                    slang = slang + add;
                    break;
                } else {
                }
            }
        }
        return slang;
    }
}