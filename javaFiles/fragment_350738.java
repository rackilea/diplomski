Drawable drawable = LoadImageFromWebOperations(ImageLink);
        imageView.setImageDrawable(drawable);


  private Drawable LoadImageFromWebOperations(String url)
    {
          try{


        InputStream is = (InputStream) new URL(url).getContent();
        Drawable d = Drawable.createFromStream(is, "src name");
        return d;
      }catch (Exception e) {
        System.out.println("Exc="+e);
        return null;
      }
    }