public enum Numbers {
    ONE(1), TWO(2), THREE(3);

    public final int num;

    private Numbers(int num) {
        this.num = num;
    }

    public static Numbers getNumber(int i){
        for(Numbers number : Numbers.values()){
            if(i == number.num){
                return number;
            }
        }
        throw new IllegalArgumentException("This number doesn't exist");
    }
}