protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException 
{
    String partName = "type"; // or "data"
    Part part = request.getPart(partName);

    // read your StringBody type
    BufferedReader reader = new BufferedReader( new InputStreamReader(part.getInputStream()));
    String line ="";

    while((line=reader.readLine())!=null)
    {
        // do Something with a line
        System.out.println(line);

    }

    // or with a binary Data
    partName="data";
    part = request.getPart(partName);

    // read your FileBody data
    InputStream is = part.getInputStream();
    // do Something with you byte data

    is.read();
    // is.read(b);
    // ..

}