Picasso.with(context)
            .load(Uri.parse(String.valueOf(albumArtUri)))
            .resize(200,200)
            .fit()
            .centerCrop()
            .into(image);