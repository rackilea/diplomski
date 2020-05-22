@POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public void upload(FormDataMultiPart formParams)
    {
        Map<String, List<FormDataBodyPart>> fieldsByName = formParams.getFields();

       //Assume i am sending only files with the request

        for (List<FormDataBodyPart> fields : fieldsByName.values())
        {
            for (FormDataBodyPart field : fields)
            {

                InputStream is = field.getEntityAs(InputStream.class);
                String fileName = field.getName();
                field.getMediaType();


   //This working fine
  FormDataContentDisposition f=field.getFormDataContentDisposition();
  System.out.println(f.getFileName());

            }
        }
    }