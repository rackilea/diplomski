ArrayList<Integer> color_vib = new ArrayList<Integer>();
Bitmap bitmap = BitmapFactory.decodeResource( getResources(), R.drawable.abc );
Palette.from( bitmap ).generate( new Palette.PaletteAsyncListener() {
  @Override
     public void onGenerated( Palette palette ) {
            //work with the palette here
             for( Palette.Swatch swatch : palette.getSwatches() ) {
                    color_vib.add( swatch.getRgb() );
                }
        }
    });