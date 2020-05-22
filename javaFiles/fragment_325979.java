/** snip **/
LayoutInflater factory = LayoutInflater.from(mContext);
View dialogView = factory.inflate(R.layout.cover_dialog,null);
ImageView coverLarge = (ImageView)dialogView.findViewById(R.id.coverLarge);
dialog = new Dialog(mContext);
dialog.setContentView(dialogView);
dialog.setTitle(book.getTitle());
coverLarge.setImageBitmap(book.getCover());
/** snip **/