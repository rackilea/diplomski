String imageUrl = BASE_URL + arrayList.get(position).getSearchUrl() + "&size=32";
Glide.with(context)
    .load(imageUrl)
    .diskCacheStrategy(DiskCacheStrategy.ALL) 
    .placeholder(R.drawable.placeholder)
    .into(viewHolder.tvIcon);