class Parent {
    List<Integer> list = new ArrayList<Integer>();
    int i;

    public void setList() {
        i = 10;
        for(int i=0; i<10; i++)
            list.add(i);
    }
}

class Child extends Parent {
    public void setList() {
        super.setList();
        list.add(i);
    }
}

public class OverrideSuperClassMethodByAddingTOList {
    public static void main(String[] args) {
        Child c1 = new Child();
        c1.setList();
        System.out.println(c1.list);
    }
}