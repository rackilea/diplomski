@JSONMapper
public static class Test {

    public static Test_MapperImpl MAPPER = new Test_MapperImpl();

    int x;
    String y;

    public Test() {
    }

    Test(int X, String Y){
            x = X;
            y = Y;
    }
}