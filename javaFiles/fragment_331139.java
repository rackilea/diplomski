Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
    @Override
    public void onGenerated(Palette palette) {
         Palette.Swatch darkVibrant = palette.getDarkVibrantSwatch();
         if (darkVibrant != null) {
              holder.cvItem.setCardBackgroundColor(darkVibrant.getRgb());
              holder.namemadah.setTextColor(darkVibrant.getTitleTextColor());
         } else {
             //dark vibrant colors don't exist, you can try to find other swatches
             //or set a default color..    
         }
    }
});