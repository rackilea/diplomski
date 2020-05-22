public class Beta {
    private Charlie charlie;

    public Beta() {
    }

    public Charlie getCharlie() {
        if (charlie == null) {
            charlie = new Charlie();
        }
        return charlie;
    }

    public void doSomethingWithCharlie() {
        getCharlie().randomize();
    }
}