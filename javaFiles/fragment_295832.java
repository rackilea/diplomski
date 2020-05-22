public void onBindViewHolder(final ContactHolder contactHolder, int i) {
    final Contact contact = contactList.get(i);
    //  Log.e("Imagename",""+"http://xesoftwares.co.in/contactsapi/profile_images/85368a5bbd6cffba8a3aa202a80563a2.jpg");//+feedItem.getThumbnail());

    String url = ServiceUrl.getBaseUrl() + ServiceUrl.getImageUserUrl() + contact.getmProfileImage();
    Log.e("url",url);

    if(contact.getmProfileImage().equals("")) {
        file = new File("");
        fileExists = file.exists();
        contactHolder.thumbnail.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.ic_account_circle_black_48dp));
    } else {
        file = new File(Environment.getExternalStorageDirectory() + "/ContactProfileImages/" + contact.getmProfileImage());
        fileExists = file.exists();
    }

    Log.e("Picasso",file.getAbsolutePath());

    Picasso.with(mContext).load(url)
        .error(R.drawable.ic_account_circle_black_24dp)
        .placeholder(R.drawable.ic_account_circle_black_24dp)
        .into(contactHolder.thumbnail);

    contactHolder.title.setText(contact.getmUserName());
    //feedListRowHolder.genre.setText(Html.fromHtml(feedItem.getGenre()));
}