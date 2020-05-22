public void writeBitmapToMemory(String filename, Bitmap bitmap) {
        FileOutputStream fos;
        // Use the compress method on the Bitmap object to write image to the OutputStream
        try {
            fos = this.openFileOutput(filename, Context.MODE_PRIVATE);
            // Writing the bitmap to the output stream
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            fos.close();

        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();


        } 
        catch (IOException e) {
            e.printStackTrace();


        }

    }