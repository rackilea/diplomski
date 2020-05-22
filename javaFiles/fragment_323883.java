public abstract class ValidableDTO<T extends ValidableDTO> implements Serializable {
    public abstract boolean isValid();
    public abstract boolean equals(T compared);
}

public class MyDTO extends ValidableDTO<MyDTO> {

    @Override
    public boolean isValid() {
        ...
    }


    @Override
    public boolean equals(MyDTO compared) {
        return true; // Comparison
    }
}