// Set by default the visibility
    main_recyclerView.setVisibility(View.GONE);
    loadLayout.setVisibility(View.VISIBLE);

    public void processFinish(List<MainDataModel> dataModels) {
         if (dataModels.isEmpty()) {
              // Handle error with an empty list
         } else {
              main_recyclerView.setVisibility(View.VISIBLE);
              loadLayout.setVisibility(View.GONE);
         }
    }