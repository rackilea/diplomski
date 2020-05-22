//hide the imageview
holder.wall.setVisibility(View.INVISIBLE);
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
                //show the imageview and set bitmap
                holder.wall.setVisibility(View.VISIBLE);
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