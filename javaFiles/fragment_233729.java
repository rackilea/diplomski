public static void main(String[] args) {
    String str = "[0 1 2]\n[0 1 1]\n[0 1 3]\n[1 2 3]\n[2 4 6]\n[9 5 2]\n[0 1 3]";
    String sequence = "[0 1 3]";

    int firstIndex = str.indexOf(sequence);
    if (firstIndex >= 0) {
        int secondIndex = str.indexOf(sequence, firstIndex + sequence.length());
        if (secondIndex >= 0) {
            String result = str.substring(firstIndex, secondIndex + sequence.length());
            System.out.println(result);
        }
    }

}