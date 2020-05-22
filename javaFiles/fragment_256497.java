public class Sandbox {

    public int intField;
    public Sandbox myField;

    public static void main(String[] args) {
        Arrays.stream(Sandbox.class.getDeclaredFields()).forEach(f ->
                System.out.println(f.getName() + " : " + f.getType().getName()));

    }
}