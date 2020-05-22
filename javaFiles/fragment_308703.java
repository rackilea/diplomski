public class BaseFragment extends Fragment implements View.OnClickListener {

@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FragTestBinding binding = FragTestBinding.inflate(inflater);

        // Set the layout's "fragment" variable so that this fragment handles the onClick.
        binding.setFragment(this);

        return binding.getRoot();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.tv_undo:
                // Your code in response to the click.
                break;
        }
    }
}