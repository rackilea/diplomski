public class MyFragment extends Fragment implements BackPressListener {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof MainActivity)
            ((MainActivity) context).setBackPressListener(this);
    }

    @Override
    public void onBackPressed() {
        //handle your back press event here
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(getActivity() instanceof  MainActivity)
            ((MainActivity)getActivity()).setBackPressListener(null);
    }
}