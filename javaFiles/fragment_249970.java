public class OnBoardingScreen extends Screen{
    @AndroidFindBy(id = "onboarding_content")
    @WithTimeout(time = 1, unit = TimeUnit.SECONDS)
    private MobileElement labelContent;

    @AndroidFindBy(id = "onboarding_skip_intro")
    @WithTimeout(time = 1, unit = TimeUnit.SECONDS)
    private MobileElement buttonSkipIntro;


    public OnBoardingScreen(MobileDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, 2, TimeUnit.SECONDS), this);

        WaitUtils.isElementPresent(driver, buttonSkipIntro, 1);

        if (!Util.areElementsLoaded(labelTitle, labelContent, buttonSkipIntro)) {
            super.setLoaded(false);
        } else {
            super.setLoaded(true);
        }