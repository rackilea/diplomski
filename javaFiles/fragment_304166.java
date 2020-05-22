public Response getPdf(  )
{
            String flag=null;
            File file = new File("C:/Users/acer/Desktop/Report.pdf");

            FileInputStream fileInputStreamReader = new FileInputStream(file);

            byte[] bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
            String encodedBase64 = new String(Base64.encodeBase64(bytes));

             JSONObject jsonObject = new JSONObject();
             JSONObject mainjsonObject = new JSONObject();

             jsonObject.put("id","121");

             jsonObject.put("pdf bytearray",encodedBase64);
             mainjsonObject.put("PDF details",jsonObject);
             flag = "" + mainjsonObject;


    return Response.status(200).entity(flag).build();
}