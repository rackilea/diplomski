private String creaPost(){
    StringBuilder s = new StringBuilder();
    s.append("?");
    s.append("&title=").append("Title");
    s.append("&content=").append("description");
    s.append("&status=").append("publish");       

    return s.toString();
}