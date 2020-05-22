public class ClassInABeanArchive {
    @Produces @SpecialX public X createSpecialX() {
        return new XSpecialImpl();
    }

    @Produces @DefaultX public X createDefaultX() {
        return new XDefaultImpl();
    }
}