public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

    //remove this
    //RecyclerView.Adapter mAdapter;

    //User this everywhere
    RestaurantAdapter adapter;

    .....


    public void sendRequest() {
        ....

        adapter = new RestaurantAdapter(MainActivity.this, restaurants);
        recyclerView.setAdapter(adapter);
        ....

    }
}