boolean c = true;
do {
    System.out.println("Enter place");
    place = t.readLine();
    c = place.equals("*");
    if (!c) {
        fOUT.writeObject(place);
    }
}while(!c);