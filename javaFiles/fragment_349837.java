Object object = getObject(..);
if (object == null) {
    response.getWriter().print("null");
    // also set the content type to application/json
}
return object;