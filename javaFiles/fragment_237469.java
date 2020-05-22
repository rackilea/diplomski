import java.util.Objects;

public class Artifact {
    private String name;
    private String version;

    public Artifact(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artifact that = (Artifact) o;
        return version.equals(that.version) &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(version, name);
    }
}