public class BasePage extends WebPage implements IAjaxIndicatorAware {   

 public BasePage(final PageParameters parameters) {
    // Home link
    AjaxLink<Page> homeLink = new AjaxLink<Page>("homeLink") {
      private static final long serialVersionUID = 1L;

      @Override
      public void onClick(AjaxRequestTarget target) {
        setResponsePage(HomePage.class);
      }
    };
    add(homeLink);
  }

  @Override
  public String getAjaxIndicatorMarkupId() {
    return "indicator";
  }