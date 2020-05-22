class Untitled {
    public static void main(String[] args) {
        int[] myArr = {1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1};
        String[] strArr = new String[4];
        String name = "";
        for(int i = 0; i < myArr.length; i++){
            name += myArr[i];
            if((i+1) % 8 == 0) {
                strArr[i/8] = name;
                name = "";
            }
        }
    }
}