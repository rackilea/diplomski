if (questionHero.getUserphoto() != null ) {
//in case you handle visibility in else block make //holder.genUserPhoto.setVisibility(View.VISIBLE) here visible 
     imageLoader.get(questionHero.getUserphoto(), ImageLoader.getImageListener(holder.genUserPhoto, R.drawable.header, android.R.drawable.ic_dialog_alert));
    } else {
//reset image by questionHero.genUserPhoto.setImageBitmap(null), or handle //visibility of holder.genUserPhoto
}