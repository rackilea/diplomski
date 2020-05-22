public SwipeRefreshLayout swipeRefreshLayout;
swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.refreshLater);
swipeRefreshLayout.setOnRefreshListener(this);

you can do needed code in the below override method:

@Override
public void onRefresh()
{
     swipeRefreshLayout.setRefreshing(false);  
}