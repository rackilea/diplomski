Person tr = tap.get(i);

        Embedded emb=new Embedded("myembeddedimage");

        StreamResource.StreamSource source = new StreamResource.StreamSource() {

            public InputStream getStream() {
                 //get blob inputstream
                 return new ByteArrayInputStream(tr.getPicture());
            }

         };
       //create StreamResource from blob inputstream and name it.
       StreamResource sourceone=new StreamResource(source, "mypicture.png");
       sourceone.setCacheTime(0l); 
       emb.setHeight("200px");
       emb.setWidth("150px");
       //if user doesn't have image, the embedded image source is set to image from resource
       emb.setSource(tr.getPicture()==null? new ThemeResource("images/user_pic.jpg"): sourceone);

       CheckBox checkbox=new CheckBox();
        checkbox.setConvertedValue(false);

       tPartners.addItem((new Object[] {emb,
                (tr.getName() +" "+ tr.getSurname()), -2,checkbox}),tr);