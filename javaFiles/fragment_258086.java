public Bitmap mergeBitmap(Bitmap fr, Bitmap sc) 
    { 

        Bitmap comboBitmap; 

        int width, height; 

        width = fr.getWidth() + sc.getWidth(); 
        height = fr.getHeight(); 

        comboBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888); 

        Canvas comboImage = new Canvas(comboBitmap); 


        comboImage.drawBitmap(fr, 0f, 0f, null); 
        comboImage.drawBitmap(sc, fr.getWidth(), 0f , null); 
        return comboBitmap;

    }