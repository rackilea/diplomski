public class MyFragment extends Fragment implements RecommendationClickListener{
...
...
...

@Override
    public void onRecommendationClicked() {
        Intent intent = new Intent(getActivity(), NextActivity.class);
        Bundle extras = new Bundle();
        extras.putBoolean("denyEditPermission", true);
        intent.putExtras(extras);

        startActivityForResult(intent, 1);

    }

@Override
public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    mAdapter = new Adapter(this.getActivity(), new ArrayList<Item>());
    mAdapter.setRecommendationClickListener(this);
    mGridView = (StaggeredGridView) getView().findViewById(R.id.grid_view);
    mGridView.setAdapter(mAdapter);
}