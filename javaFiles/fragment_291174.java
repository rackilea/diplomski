public class NumbersClickListener implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        Intent numberIntent = new Intent(view.getContext(),
                NumbersActivity.class);
        view.getContext().startActivity(numberIntent);
    }
}