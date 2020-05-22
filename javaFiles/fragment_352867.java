public class MyFilter<T> implements GenericFileFilter<T> {
    @Override
    public boolean accept(GenericFile<T> file) {
        if (file.getFileName().matches("^[A-Za-z0-9_]+\-\d{4}\-\d{2}\-\d{2}T\d{2}\-\d{2}\-\d{2}\+\d{2}\-\d{2}\.zip$"))
            return true;
        return false;
    }
}