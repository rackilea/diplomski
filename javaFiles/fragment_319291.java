@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);


            if (resultCode == RESULT_OK) {

                if (requestCode == IMAGE_GALLERY_REQUEST) {
                    Uri imageUri = data.getData();

                    Long tsLong = System.currentTimeMillis();
                    String now = tsLong.toString();

                    String destitaion =folderPath+"/"+now+".jpg";

                    savefile(imageUri.getPath(),destitaion);
            }

        }
    }


    void savefile(String sourceFilename,String destinationFilename)
    {
        //String sourceFilename= sourceuri.getPath();

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        boolean exp_occuered=false;
        try {
            bis = new BufferedInputStream(new FileInputStream(sourceFilename));
            bos = new BufferedOutputStream(new FileOutputStream(destinationFilename, false));
            byte[] buf = new byte[1024];
            bis.read(buf);
            do {
                bos.write(buf);
            } while(bis.read(buf) != -1);
        } catch (IOException e) {
            e.printStackTrace();
            exp_occuered=true;
        }
        finally {
            try {
                if (bis != null) bis.close();
                if (bos != null) bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(!exp_occuered)
        {
            //the image has been saved properly
        }

    }