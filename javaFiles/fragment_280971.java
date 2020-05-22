//1. Initialize the viewModel 
NoticeViewModel viewModel = ViewModelProviders.of(this).get(NoticeViewModel.class);

//2. Subscribe to the saved notices live-data to get updates in your view
viewModel.getNoticeLiveData().observe(this
       list -> {
                if (list.isEmpty()) {
                       return;
                }

                // Add the list in your adapter

            });