// I assume that both Project and MyJsonHttpResponseHandler has hashCode() and equals() methods
// MyJsonHttpResponseHandler is a subcalss of JsonHttpResponseHandler with hashCode() and equals() methods
private final ConcurrentHashMap<MyJsonHttpResponseHandler, Project> map = new ConcurrentHashMap<>();
...
for (int i=0; i<projects.size(); i++) {
    MyJsonHttpResponseHandler handler = new MyJsonHttpResponseHandler() {
        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONObject response)
        {
            Project project = map.get(this);
            project.setAmount(<things from response>);

            map.remove(this);
        }
    };
    map.put(handler, projects.get(i));
    post("api/Project/getProductionTime", rp, handler);
}