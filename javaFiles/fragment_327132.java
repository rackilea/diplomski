if(strUserImg.length()>0){
            Glide.with(context)
                    .load(strUserImg)
                    .into(holder.image);
} else {
      Glide.with(context)
                    .load(<PLACEHOLDER_IMAGE>)
                    .into(holder.image);


}