@Override
public int getItemCount() {
    if (rssObject == null) {
         Toast.makeText(context, "rssObject is NUll", Toast.LENGTH_SHORT).show();
         return 0;
    }
    else {
    return (rssObject!=null && rssObject.items!=null)? rssObject.items.size():0;
    }
}