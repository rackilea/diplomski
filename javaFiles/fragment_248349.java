public class MyActivity implements OnStockAddedListener {

    @Override
    public void onStockAdded(Stock stock) {
        FragmentA fragmentA = (FragmentA) getSupportFragmentManager()
                .findFragmentByTag(/* insert tag here */);

        fragmentA.handleStockAdded(stock);
    }
}