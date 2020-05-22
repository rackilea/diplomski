@Controller("mobileRedirectController")
public class MobileRedirectController extends AbstractRedirectController {

    @Resource("mobileUserAgent")
    public MobileRedirectController(Set<String> deviceUserAgent) {
        setDeviceUserAgent(deviceUserAgent);
    }
}

@Controller("tabletRedirectController")
public class TabletRedirectController extends AbstractRedirectController {

    @Resource("tabletUserAgent")
    public TabletRedirectController(Set<String> deviceUserAgent) {
        setDeviceUserAgent(deviceUserAgent);
    }
}