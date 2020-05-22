class Superclass {
    private Test test;

    @Autowired
    public Test getTest(Test test) {
        return this.test = test;
    }
}

class Subclass extends Superclass {
    @Override
    @Autowired
    public Test getTest(Test2 test2) {
        return super.getTest(test2);
    }

}