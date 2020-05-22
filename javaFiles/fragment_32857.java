class ClassName
{
public static void main(String[] args) {

    FixCapacityStackOfString fcstack = new FixCapacityStackOfString(100);
}

static class FixCapacityStackOfString {

    public FixCapacityStackOfString(int a) {
        list = new String[a];
    }

    private int size;
    private String[] list;
    }

}