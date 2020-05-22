public final class ByExtensionFileFilter
    extends FileFilter
{
    private final String description;
    private final Set<String> extensions = new HashSet<String>();

    public ByExtensionFileFilter(final String description,
        final String first, final String... other)
    {
        this.description = description;

        extensions.add('.' + first);
        for (final String s: other)
            extensions.add('.' + s);
    }

    @Override
    public boolean accept(final File f)
    {
        final String name = f.getName();
        for (final String extension: extensions)
            if(name.endsWith(extension))
                return true;

        return false;
    }

    @Override
    public String getDescription()
    {
        return description;
    }
}