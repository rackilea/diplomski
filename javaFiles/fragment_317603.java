public void onClick(View v) {
   //...
    if (mRewardedVideoAd.isLoaded()) {
           mRewardedVideoAd.show();   
           // Ads already shown you may want to manually hide other images here                 
      }else{
            // We only need to add to list when ads not loaded
            // We also want to make sure we don't add same view to the list twice
           if(!views_to_hide.contains(holder.image))
              views_to_hide.add(holder.image);
      }});
   //...