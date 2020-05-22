public static StringBuilder x;

public static void doChange(StringBuilder x)

{

    x.append("world");

}

public static void main(String arg[]) {
    x = new StringBuilder("hello ");

    doChange(x);

    System.out.println(x);
}