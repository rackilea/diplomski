@ApplicationScoped //probably-but not necessarily???
public class Demo {
    @Inject
    private final Service1 service1;
    @Inject
    private final Service2 service2;

    public YouAreNotAllowedToModifyMe makeYouAreNotAllowedToModifyMe(HttpServletRequest request) {
        return new YouAreNotAllowedToModifyMeImpl(request);
    }

    private class YouAreNotAllowedToModifyMeImpl implements YouAreNotAllowedToModifyMe {
        YouAreNotAllowedToModifyMeImpl(HttpServletRequest request) {
            // do what you must...
        }

        // implement it!
        // remember, you can actually use service1 &
        // service 2 from the enclosing instance
    }
}