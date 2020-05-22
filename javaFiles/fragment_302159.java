public final class Sample {
    private final int number;

    public Sample(int number) {
        this.number = number;
    }

    public int getNumber(){
        return number;
    }

    public Sample add(int number){
        return new Sample(this.number + number);
    }
}