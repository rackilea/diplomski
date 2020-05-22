@GetMapping
public final ReturnType getAll(CustomDTO customObj) {
    ...
}

class CustomDto {
    int x;
    String s;

    public void setX(int x) {
        this.x = x;
    }

    public void setS(String s) {
        this.s = s;
    }
}