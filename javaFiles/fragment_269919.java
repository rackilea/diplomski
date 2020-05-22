for (int x=0; x < input.size(); x++) {
    String reverse = "";
    for (int z=input.get(x).length(); z > 0; z--) {
        reverse += input.get(x).charAt(z - 1);
    }

    System.out.println(reverse);
}