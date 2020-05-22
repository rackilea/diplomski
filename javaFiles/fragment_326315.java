public class NullAuditorBean implements AuditorAware {

    @Override
    public Object getCurrentAuditor() {
        return null;
    }
}