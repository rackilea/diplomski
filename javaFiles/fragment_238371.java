public int[] getCoord(int[] coords) {
    Scanner scanner = new Scanner(System.in);
    coords[0] = getX(scanner, coords);
    coords[1] = getY(scanner, coords);
    scanner.close()
    return coords;
}