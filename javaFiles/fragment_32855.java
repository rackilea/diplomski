class ClassName
{
public static void main(String[] args) {

    ClassName obj = new ClassName();
    FixCapacityStackOfString fcstack =   obj.new FixCapacityStackOfString(100);
}

class FixCapacityStackOfString {

    public FixCapacityStackOfString(int a) {
        list = new String[a];
    }

    private int size;
    private String[] list;
    }

}