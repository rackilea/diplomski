@Override
public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()){
        case R.id.add_image:
            localBroadcastManager.sendBroadcast(addImageIntent);
            break;
        case R.id.save_meme:
            localBroadcastManager.sendBroadcast(saveIntent);
            break;
        case R.id.share_meme:
            localBroadcastManager.sendBroadcast(shareIntent);
            break;
        default:
            return super.onOptionsItemSelected(item);
    }

    return true;
}