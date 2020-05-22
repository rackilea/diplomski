imageview.setOnClickListener(new View.OnClickListener() {

 public void onClick(View view) {

     WallpaperManager myWallpaperManager 
        = WallpaperManager.getInstance(context);
        try {
            myWallpaperManager.setResource(GalImages[position]);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }       

}

});