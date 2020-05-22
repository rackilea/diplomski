public class MyPresenter implements MyView.Presenter {
    private MyView view;

    // ... Constructor etc. goes here...

    @Override
    public void render() {
        // Make RPC call immediately when Presenter should begin rendering.
        ClientFactory.getService().getData(new AsyncCallback<MyResult>() {
            @Override
            public void onSuccess(MyResult result) {
                // Pass data to view for rendering (when appropriate.)
                view.render(result);
            }

            @Override
            public void onFailure(Throwable caught) {
                // Handle RPC error.
            }
        });
    }
}