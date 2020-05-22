@SpringUI
@Theme("new")
@Widgetset("com.example.NewWidgetSet")
public class NewUI extends UI implements Constants {
    private static final Logger logger = LoggerFactory.getLogger(NewUi.class);
    private CssLayout contentLayout;
    private SpringViewProvider viewProvider;

    @Inject
    public RessuUi(HeaderLayout headerLayout, SpringViewProvider viewProvider) {
        this.headerLayout = headerLayout;
        this.viewProvider = viewProvider;
    }

    @Override
    protected void init(VaadinRequest request) {
        initNavigator();
        initRootLayout(); // init here content
    }

    private void initNavigator() {
        Navigator newNavigator = new Navigator(this, contentLayout);
        newNavigator.addProvider(viewProvider);
        setNavigator(newNavigator);
    }

    @Override
    public void detach() {
        logger.debug("Detaching UI.");
    }

}