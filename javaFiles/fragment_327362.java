public final class FragmentContainer extends Fragment {
    private final List<FragmentMetaData> fragmentMetaDataStack = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initialize(inflater, container, R.layout.fragment_container);

        for (FragmentMetaData metaData : fragmentMetaDataStack) {
            showNestedFragment(Fragment.instantiate(getActivity(), metaData.className, metaData.fragmentBundle), fragmentMetaDataStack.indexOf(metaData) > 0, true);
        }

        return getFragmentView();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getChildFragmentManager().getFragments() == null){
            return;
        }

        int stackDepth = getChildFragmentManager().getFragments().size();
        if (stackDepth > 0 && fragmentMetaDataStack.size() < stackDepth &&
                getChildFragmentManager().getFragments().get(fragmentMetaDataStack.size() - 1) != null) {
            getChildFragmentManager().getFragments().get(fragmentMetaDataStack.size()-1).onResume();
        }
    }

    public void showNestedFragment(final Fragment fragment, final boolean addToBackStack, final boolean isRestoring) {
        final FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.nestedContainer, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null);
        }

        if (!isRestoring) {
            fragmentMetaDataStack.add(new FragmentMetaData(fragment.getClass().getName(), fragment.getArguments()));
        }

        fragmentTransaction.commitAllowingStateLoss();
    }

    public void onBackPressed() {
        if (getChildFragmentManager().getBackStackEntryCount() > 0) {
            getChildFragmentManager().popBackStack();
            fragmentMetaDataStack.remove(fragmentMetaDataStack.size() - 1);
        } else {
            getActivity().finish();
        }
    }

    public void addMetaData(FragmentMetaData metaData) {
        fragmentMetaDataStack.add(metaData);
    }

    public void clearStackExceptRootFragment() {
        getChildFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        while (fragmentMetaDataStack.size() > 1) {
            fragmentMetaDataStack.remove(1);
        }
    }
}