public static void main(String[] args) {
    String[] hotel = new String[11];
    hotel = initialise(hotel);
    Menu(hotel);

}

private static String[] initialise(String hotelRef[]) {
    for (int x = 0; x < hotelRef.length; x++) {
        hotelRef[x] = "EMPTY";
    }
    return hotelRef;
}

private static void Menu(String[] hotel) {
    Arrays.sort(hotel);
    for (int x = 0; x < hotel.length; x++) {
        System.out.println(Arrays.toString(hotel));
    }
}