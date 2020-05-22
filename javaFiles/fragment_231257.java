public List<ImageView> allImages = new ArrayList<ImageView>();

public List<ImageView> getAllImages(){
        return this.allImages;
    }

this.allImages.add((ImageView) convertView
                .findViewById(R.id.imgbtn_favorite));