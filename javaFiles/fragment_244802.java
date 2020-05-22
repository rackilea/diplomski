public static void main(String[] args) {
    int maxItter = 20;
    int index = maxItter;
    do {
        index --;
        int itterNum = maxItter-index;

        //stuff

        if (itterNum == 20) {
            index = 20;
        }
        System.out.println(itterNum + " " + index);
    } while (index > 0);
    index = index + 1;
}