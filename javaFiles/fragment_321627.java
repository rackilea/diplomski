class MainActivity extends AppCompatActivity {

 @Override
 protected void onCreate(@Nullable Bundle savedInstanceState) {
  YourBottomSheetDialogFragment bottomSheetFragment = new YourBottomSheetDialogFragment();
  Bundle bundle = new Bundle();
  bottomSheetFragment.setArguments(bundle);
  bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
 }

 public void setResultFromFragment(String data) {
  ...
 }
}

/**
* Calling Activity's method from Fragment
*/
class YourBottomSheetDialogFragment extends BottomSheetDialogFragment {

 @Override
 public void onCreate(@Nullable Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  ((MainActivity) getActivity()).setResultFromFragment("");
 }
}