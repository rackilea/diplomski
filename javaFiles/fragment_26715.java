import java.util.Objects;
.
.
.
private String shc;
.
.

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Hello hello = (Hello) o;
    return shc.equals(hello.shc);
}

@Override
public int hashCode() {
    return Objects.hash(shc);
}