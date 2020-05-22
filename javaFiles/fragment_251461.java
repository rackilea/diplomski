for(byte[] imageList:imageMap)
{
    System.out.println(imageList.toString()+"   "+imageList.length);

    byteArrayOutputStream.write(imageList);

    byteArrayOutputStream.writeTo(response.getOutputStream());

    is = new ByteArrayInputStream(byteArrayOutputStream.toByteArray()); 
    inputPdfList.add(is);
}