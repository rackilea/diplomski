private int pageNo = 0;

private List<Model> getPagedData(int page) {
    // TODO retrieve JSON from server
    // e.g. GET http://fakewebsite.com?page=2

    if (success) {
        pageNo++;
    }
    else {
        // TODO handle error
    }
}

modelList.addAll(getPagedData(pageNo)); // add newly retrieved data
adapter.notifyDataSetChanged(); // tells RecyclerView to bind new models