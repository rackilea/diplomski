public class CategoryFragment extends Fragment {
    public static CategoryFragment newInstance(int categoryId) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle extras = new Bundle();
        extras.putInt("categoryId", categoryId);
        fragment.setArguments(extras);
        return fragment;
    }
    ...
    // Determine which category you're on
    private int getCategoryId() {
        return getArguments().getIntExtra("categoryId", 1);
    }
}