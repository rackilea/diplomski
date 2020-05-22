private static void positionOf(char target, String query) {

    int position = 0;
    int result = 0;

    while(-1 != (result = query.indexOf(target, position))){

        System.out.println(result);
        position = result +1;
    }
}