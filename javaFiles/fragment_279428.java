class BeanDemo {
    private Double value;

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }
}

class Test {
    public static void main(String[] args) {
        BeanDemo beanDemo = new BeanDemo();
        int val=7;
        if (val < 5) {
            beanDemo.setValue(23.456);
        }
        Double value = beanDemo.getValue(); // value will be null
        System.out.println(value);
    }
}