public class CustomAdapter extends ArrayAdapter {
     int [] food_image;

    public CustomAdapter(@NonNull Context context, String [] food_text,int [] food_image) {
        super(context,R.layout.custom_row,food_text);
        this.food_image=food_image;
      }
  }