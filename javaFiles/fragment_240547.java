public class File < T > {

    private T file;
    private String location;

    public T getFile() {
        return file;
    }
    public void setFile( T file ) {
        this.file = file;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation( String location ) {
        this.location = location;
    }

}