public class AgeFilter<T> implements GenericFileFilter<T> {

    @Override
    public boolean accept(final GenericFile<T> file) {
        long now = System.currentTimeMillis();
        long lastModified = file.getLastModified();

        return now-lastModified > CUT_OFF_AGE;
    }
}