public class FragmentList extends Fragment {

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View v = inflater.inflate(R.layout.fragment_fragment_list, container, false);
    final FoodAdapter adapter;

    final List<Food> foodList = new ArrayList<>();
    recyclerView = v.findViewById(R.id.recyclerView);
    recyclerView.setHasFixedSize(true);

    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    adapter = new FoodAdapter(getActivity(), foodList);
    recyclerView.setAdapter(adapter);

    String url = "url";
    StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Log.i(TAG, response);
            try {
                JSONArray foodResp = new JSONArray(response);
                for (int i = 0; i < foodResp.length(); i++) {
                    JSONObject foodObj = foodResp.getJSONObject(i);
                    foodList.add(
                            new Food(
                                    foodObj.getInt("u_id"),
                                    R.drawable.ic_launcher_background,
                                    foodObj.getString("mealTitle"),
                                    foodObj.getString("mealDesc"),
                                    foodObj.getString("cityName"),
                                    foodObj.getString("userName")
                    ));
                }

                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }

            } catch (Exception e) {
                Log.i(TAG, "Error: " + e.getMessage());
            }

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.i(TAG, "err: " + error.toString());
        }
    }){
        @Override
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> params = new HashMap<>();
            params.put("data", "value");

            return params;
        }
    };
    Volley.newRequestQueue(getActivity()).add(sr);

    return v;
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /* --- Adding the Listener here --- */
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                //Food food = this.foods.get(position);
                Log.i(TAG, "Clicked!");
            }
        }));
    }

}