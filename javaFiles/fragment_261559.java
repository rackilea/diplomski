InfiniteGallery galleryOne = (InfiniteGallery) findViewById(R.id.galleryOne);
        galleryOne.setAdapter(initializeImages()); 
        galleryOne.setSelection(galleryOne.getCount()/2);            





    }

    private InfiniteGalleryAdapter initializeImages() {
        InfiniteGalleryAdapter galleryAdapter = null;

        String city = getIntent().getStringExtra("cityname");
        tv.setText("My "+city+" Pictures"); 

        if(city.equalsIgnoreCase("City1")){
            int[] tempimages = { R.drawable.ic_launcher, R.drawable.ic_launcher,R.drawable.ic_launcher };  
            String[] name = { "Image 1","Image 2", "Image 3"};  

            galleryAdapter=new InfiniteGalleryAdapter(this, tempimages, name);
        }else if(city.equalsIgnoreCase("City2")){
            int[] tempimages = { R.drawable.ic_launcher, R.drawable.ic_launcher,R.drawable.ic_launcher };  
            String[] name = { "Image 4","Image 5", "Image 6"};  

            galleryAdapter=new InfiniteGalleryAdapter(this, tempimages, name);


        }else if(city.equalsIgnoreCase("City3")){
            int[] tempimages = { R.drawable.ic_launcher, R.drawable.ic_launcher,R.drawable.ic_launcher };  
            String[] name = { "Image 7","Image 8", "Image 9"};  

            galleryAdapter=new InfiniteGalleryAdapter(this, tempimages, name);

        }else if(city.equalsIgnoreCase("City4")){
            int[] tempimages = { R.drawable.ic_launcher, R.drawable.ic_launcher,R.drawable.ic_launcher };  
            String[] name = { "Image 10","Image 11", "Image 12"};  

            galleryAdapter=new InfiniteGalleryAdapter(this, tempimages, name);

        }else if(city.equalsIgnoreCase("City5")){
            int[] tempimages = { R.drawable.ic_launcher, R.drawable.ic_launcher,R.drawable.ic_launcher };  
            String[] name = { "Image 13","Image 14", "Image 15"};  

            galleryAdapter=new InfiniteGalleryAdapter(this, tempimages, name);
        }
        return galleryAdapter;





    }