public static void main(String[] args) {
        Coordinates c1 = new Coordinates(10, 15);
        List<Coordinates> coordinatesList = new ArrayList<>();
        coordinatesList.add(c1);

        Coordinates c2 = new Coordinates(10, 15);
        for(Coordinates coordinate:coordinatesList ){
        if (coordinate.equals(c2)) {
            System.out.println("Equal ");
        } else {
            System.out.println("Not Equal ");
        }
        }
    }