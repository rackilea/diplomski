public static void main(String[] args) throws Exception {
    String trimm = "ABC 123|1|2 ABC '123|1|2|\"Jan 30 2018  2:34:13:000AM\"|dd1|1|\"Jan 30 2018  2:56:08:000AM\"|EST' ABC 20180821\n" +
            "ABC 123|1|2 ABC '123|1|2|\"Jan 30 2018  2:34:13:000AM\"|dd1|1|\"Jan 30 2018  2:56:08:000AM\"|EST' ABC 20180821\r\n";

    System.out.println("---------------------------------------------------Before replace Start of the input---------------------------------------------------");
    System.out.println(trimm);
    System.out.println("---------------------------------------------------Before replace End of the input---------------------------------------------------");

    System.out.println("---------------------------------------------------After replace Start of the input---------------------------------------------------");
    trimm = trimm.replaceFirst("[\n\r]+$", "");
    System.out.println(trimm);
    System.out.println("---------------------------------------------------After replace End of the input---------------------------------------------------");

}