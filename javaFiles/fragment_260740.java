public abstract class MyBaseFragment extends Fragment {
    private FloatingActionButton fab;

    protected void initFab(View contentView, int resourceId) {
        fab = (FloatingActionButton) contentView.findViewById(resourceId);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchDetailsDialogFragment();
            }
        });
    }

    protected abstract void launchDetailsDialogFragment();
}