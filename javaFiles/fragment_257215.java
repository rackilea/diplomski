File pictureFile = getOutputMediaFile(getActivity(), MEDIA_TYPE_IMAGE);
        if (pictureFile == null) {
            return;
        }
        Bitmap bitmap =BitmapFactory.decodeByteArray(data,0,data.length);

            FileOutputStream fos = new FileOutputStream(pictureFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();