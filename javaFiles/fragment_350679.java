public class SpinnerAdapter {
    @BindingAdapter("entries")
    public static void setEntries(Spinner view, final List<String> values) {
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter() {
            // Use values to implement the SpinnerAdapter
        }
        view.setAdapter(spinnerAdapter);
    }
}