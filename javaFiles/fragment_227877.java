new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>()
{
    @Override
    public Boolean apply(final WebDriver webDriver)
    {
        String SCRIPT =
          "return window.Tapestry.pageLoaded === true    " +
          "  && window.Ajax.activeRequestCount === 0     " +
          "  && window.Effect.Queue.effects.length === 0 " ;

        Object result = ((JavascriptExecutor)webDriver).executeScript(SCRIPT);
        return Boolean.TRUE.equals(result);
    }
});