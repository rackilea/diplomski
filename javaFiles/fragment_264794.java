static public String buildHeaderList(ServletRequest request){
    StringJoiner headerList = new StringJoiner(",");

    Request req = (Request) request;
    HttpFields fields = req.getMetaData().getFields();

    for (HttpField f : fields)
    {
        if (f!=null)
            headerList.add(f.getName());
    }

    return headerList.toString();
}