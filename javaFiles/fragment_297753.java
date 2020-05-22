//load default image first                 
holder.wall.setImageResource(R.id.your_default_image_resource);
//load actual image
Ion.with(context)
            .load(wallurl)
    .asBitmap()
    .setCallback(new FutureCallback<Bitmap>() {
        @Override
        public void onCompleted(Exception e, Bitmap result) {
            holder.progressBar.setVisibility(View.GONE);
            if (e != null) {
                e.printStackTrace();
            } else if (holder.wall.getTag() != null && holder.wall.getTag().equals(wallurl)) {
                holder.wall.setImageBitmap(result);
                if (usePalette) {
                    Palette p;
                    if (mPaletteCache.containsKey(wallurl)) {
                        p = mPaletteCache.get(wallurl);
                    } else {
                        p = new Palette.Builder(result).generate();
                        mPaletteCache.put(wallurl, p);
                    }
                    if (p != null) {
                        Palette.Swatch wallSwatch = p.getVibrantSwatch();
                        if (wallSwatch != null) {
                            holder.titleBg.setBackgroundColor(wallSwatch.getRgb());
                            holder.titleBg.setAlpha(1);
                            holder.name.setTextColor(wallSwatch.getTitleTextColor());
                            holder.name.setAlpha(1);
                        }
                    }
                }
            }
        }
    });