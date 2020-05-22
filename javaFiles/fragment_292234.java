for (int idno: idArray) {
    if (idno % 10000 >= 5000) {
        System.out.println(idno+" is Male");
    } else {
        System.out.println(idno+" is Female");
    }
}