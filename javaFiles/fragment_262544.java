public class NumberAnalyzer {

    private List<Number> list;

    public NumberAnalyzer() {
        this.list = new ArrayList<Number>();
    }

    public NumberAnalyzer(String numbers) {
        setList(numbers);
    }

    public void setList(String numbers) {
        String[] nums = numbers.split(" ");
        this.list = new ArrayList<Number>();
        for(String num: nums) 
            list.add(new Number(Integer.parseInt(num)));
    }

}