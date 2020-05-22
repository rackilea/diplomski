public class GridViewAdapter extends ArrayAdapter<ImageItem> {

    // your old logic here

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // your old logic here

        // holder.image.setImageBitmap(item.getImage());
        Picasso.with(context).load(item.getImageResource()).into(holder.image);
    }

    // your old logic here

}