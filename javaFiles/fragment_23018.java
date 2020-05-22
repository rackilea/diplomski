public class ContentFragment extends ListFragment {
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Toast.makeText(this.getActivity().getBaseContext(), this.getTag(), Toast.LENGTH_LONG).show();
    }
}