public class Task implements TextExportable {
    private String name;

    public Task() {} // For the pseudo-serialization

    public Task(String name) { // For creating the object by hand
        this.name = name;
    }

    public char getClassIdentifier() {
        return 'T';
    }

    public String toString() {
        return getClassIdentifier()+name;
    }

    public void initFromString(String line) {
        this.name = line;
        // Here, you would need extra parsing if you have more than one attribute
        // and dissect the line
    }
}