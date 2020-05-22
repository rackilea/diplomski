public class FileNameChecker implements Checker<File>
{
    private String name;

    public FileNameChecker(String name) {
        this.name = name;
    }

    @Override
    public boolean hasProperty(File f) {
        return f.getName().equals(name);
    }

}