public class CustomClickListener implements View.OnClickListener {

    int position;


    public CustomClickListener(int position) {

        this.position = position;
    }

    @Override
    public void onClick(View v) {

        String tag = (String) v.getTag();
        String identifier[] = tag.split("_");

        // this line saves my state in the Setter Getter Class
        Constants.demoDatas.get(position).setLiked(true);

    }
}