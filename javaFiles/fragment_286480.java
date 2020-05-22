@Provider
public class MagicFilter implements ContainerRequestFilter {
    @MagicAnnotation
    private Provider<String> magic;

    @Override
    public void filter(final ContainerRequestContext context) {
                           // Provider#get()
        if (!"secret".equals(magic.get())) {
            throw new NotFoundException();
        }
    }
}