public class test {

    int i = 0; // superfluous, "int i;" is enough 

    public test() {
        int i = 0; // hides field i
    }

    public void addi() {
        int i = i + 1; // hides field i; won't increment field i
    }
}