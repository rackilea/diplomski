public abstract class AbstractActivity<T extends ApplicationPlace, V extends View> implements Activity {

    protected ClientFactory clientFactory;
    protected EventBus eventBus;
    protected AcceptsOneWidget parentPanel;
    protected final T place;
    protected final V display;

    protected final List<HandlerRegistration> handlers = new ArrayList<HandlerRegistration>();


    public AbstractActivity(T place, ClientFactory clientFactory, V display) {
        this.place = place;
        this.clientFactory = clientFactory;
        this.display = display;
    }

    protected void setEventBus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    protected EventBus getEventBus() {
        return this.eventBus;
    }

    @Override
    public void start(AcceptsOneWidget parentPanel, EventBus eventBus) {
        this.parentPanel = parentPanel;
        this.eventBus = eventBus;

        parentPanel.setWidget(display.asWidget());
        bindToView();
        WorkingIndicator.getInstance().hide();
    }

    public AcceptsOneWidget getParentPanel() {
        return parentPanel;
    }

    public T getPlace() {
        return place;
    }

    public V getDisplay() {
        return display;
    }

    public ClientFactory getClientFactory() {
        return clientFactory;
    }

    /**
     * Shortcut getter for the CSS style in Resources.
     *
     * @return
     */
    public Style style() {
        return clientFactory.getResources().style();
    }

    @Override
    public String mayStop() {
        return null;
    }

    @Override
    public void onCancel() {
    }

    @Override
    public void onStop() {
      cleanup();
      display.reset();
      WorkingIndicator.getInstance().show();
    }

  protected void addHandler(HandlerRegistration registration) {
    handlers.add(registration);
  }

    public List<HandlerRegistration> getHandlers() {
        return handlers;
    }

    protected void cleanup() {
        for (HandlerRegistration handler : handlers) {
            handler.removeHandler();
        }
    }

    /**
     * This function will be called immediately after adding the view to the
     * DOM. This function should be used to hook up click handlers, populate
     * HasData handlers and such.
     */
    protected abstract void bindToView();

    protected DaoRequestFactory daoRequestFactory() {
        return clientFactory.daoRequestFactory();
    }

    protected AnalyticsTaskRequest analyticsTaskRequest() {
        return clientFactory.daoRequestFactory().analyticsTaskRequest();
    }

    protected EventBus eventBus() {
        return clientFactory.getEventBus();
    }

    protected PersonProxy currentPerson() {
        return clientFactory.getCurrentPerson();
    }
}