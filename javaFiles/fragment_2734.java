MultipartBody.Part[] partfiles=new MultipartBody.Part[4];


        try{
            int size=imagesList.size();
            for(int i=0;i<imagesList.size();i++){
                if(i<4){

                    try{
                        partfiles[i] = MultipartBody.Part.createFormData("pics["+i+"]",
                                Calendar.getInstance().getTimeInMillis()+".jpg",
                                RequestBody.create(MediaType.parse("image/*"),getJPEGFile(new File(imagesList.get(i)))));
                    }catch (Exception e){}

                }
            }

        }catch (Exception e){}