public static void main(String[] args) {
    String[][] arr1 = {
        {"a", "b", "c", "d"}, 
        {"a", "d", "f"}, 
        {"d", "a", "b"}, 
        {"a", "b", "c", "d"}
    };
    String[] arr2 = {"a", "b", "d", "f"};

    for (String[] letters : arr1) {
        boolean containsAll = true;
        for (String letter : letters) {
            boolean match = false;
            for (String s : arr2) {
                if (letter.equals(s))
                    match = true;
            }
            if(!match){
                containsAll = false;
                break;
            }
        }
        if(containsAll){
            System.out.println(Arrays.toString(letters));
        }
    }

}