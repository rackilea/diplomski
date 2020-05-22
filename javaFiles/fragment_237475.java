mRecyclerView.setHasFixedSize(false);
linearLayoutManager = new LinearLayoutManager(getActivity());
mRecyclerView.setLayoutManager(linearLayoutManager);
CompleteWorkoutRecyclerAdapter adapter = new CompleteWorkoutRecyclerAdapter(list, getContext(),
                                getActivity());
mRecyclerView.setAdapter(adapter);