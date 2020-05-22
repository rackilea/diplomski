public final class Foo
{
    public static void main(final String... args)
    {
        final ClassLoader loader = Foo.class.getClassLoader();

        final URL[] urLs = ((URLClassLoader) loader).getURLs();

        for (final URL url : urLs) {
            System.out.println(url);
            System.out.println(Files.probeContentType(Paths.get(url.toURI())));
        }
    }
}