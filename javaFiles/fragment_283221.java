public class CustomAdapter extends ArrayAdapter<Food> {

   public CustomAdapter(@NonNull Context context, List<Food> items) {
        super(context,R.layout.custom_row,items);
      }

@NonNull
@Override
public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    LayoutInflater inflater = LayoutInflater.from(getContext());
    View foodView = inflater.inflate(R.layout.custom_row,parent,false);

    Food singleFoodItem = getItem(position);
    TextView Food_text = (TextView) foodView.findViewById(R.id.Food_text);
    ImageView food_image = (ImageView) foodView.findViewById(R.id.food_image);

    Food_text.setText(singleFoodItem.getText());
    food_image.setImageResource(singleFoodItem.getImageID());
    return foodView;
}}