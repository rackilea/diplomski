if (req.getRequest().equals(Request.GET_CARS)) {
    Response response = new Response();
    response.setCars(manager.getAvailableCars());
    out.writeObject(response);
    continue;
}