@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()){
        case R.id.add_image:
            localBroadcastManager.sendBroadcast(addImageIntent);
            return true;
        case R.id.save_meme:
            localBroadcastManager.sendBroadcast(saveIntent);
            return true;
        case R.id.share_meme:
            localBroadcastManager.sendBroadcast(shareIntent);
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
}