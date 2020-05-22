try {
    JSONObject response = future.get();
    System.out.println("response.toString() = " + response.toString());
    return true;
} catch (InterruptedException | ExecutionException e) {
    if (VolleyError.class.isAssignableFrom(e.getCause().getClass())) {
        VolleyError ve = (VolleyError) e.getCause();
        System.err.println("ve = " + ve.toString());
        if (ve.networkResponse != null) {
            System.err.println("ve.networkResponse = " +
                               ve.networkResponse.toString());
            System.err.println("ve.networkResponse.statusCode = " +
                               ve.networkResponse.statusCode);
            System.err.println("ve.networkResponse.data = " +
                               new String(ve.networkResponse.data));
            return false;
        }
    }
}