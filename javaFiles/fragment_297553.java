public static void main(String[] args) {
    String str="23.9°C";
    System.out.println(str.replaceAll("[^0-9.]+", " ").toString());
    str="52.8%RH";
    System.out.println(str.replaceAll("[^0-9.]+", " ").toString());
    str="13.7°C";
    System.out.println(str.replaceAll("[^0-9.]+", " ").toString());
}

23.9 
52.8 
13.7