class MySingleton {
    private MySingleton() {
    }
}

class Test {
    public void test() throws Exception {
        Constructor<MySingleton> constructor = MySingleton.class.getConstructor();
        constructor.setAccessible(true);
        MySingleton otherSingleton = constructor.newInstance();
    }
}