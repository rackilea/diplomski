class PrintPackSummaryHandler<T> implements AsyncCallback<String> {
    //Get the Pack Summary details
    PackSummaryView view;

    public PrintPackSummaryHandler(PackSummaryView view) {
        this.view = view;
    }

    public void onFailure(Throwable ex) {
        System.out.println("RPC call failed - PackSummaryView - PrintPackSummaryHandler.");
        Window.alert("Connection failed - please retry.");
    }
    public void onSuccess(String result) {
        Window.open("data:application/csv;charset=utf-8,"+result,"_parent", "location=no") ;
        System.out.println("Download succeed !!"+result);
    }
}