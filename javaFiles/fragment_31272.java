public class LoadSpinnerData {
public static void loadSpinnerData(Context context, ArrayList<ItemCategory> array, Spinner spinner) {

    // Creating adapter for spinner
    ArrayAdapter<ItemCategory> dataAdapter = new ArrayAdapter<ItemCategory>(context,
            R.drawable.simple_spinner_item, array);

    // Drop down layout style - list view with radio button
    dataAdapter
            .setDropDownViewResource(R.drawable.simple_spinner_dropdown_item);

    // Attaching data adapter to spinner
    spinner.setAdapter(dataAdapter);
}
}