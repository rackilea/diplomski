if (itemsObject.length() == 0) {
    // Set GONE Visibility of TextView
} else {
    for (int a = 0; a < itemsObject.length(); a++) {
        ...

        //Remove from here
        /*adapter.addAll(modelGetProductSearchList);
        progressBar.setVisibility(View.GONE);
        tvTidakAdaHasil.setVisibility(View.GONE);*/    
    }

    //Add list here
    adapter.addAll(modelGetProductSearchList);
    progressBar.setVisibility(View.GONE);
    tvTidakAdaHasil.setVisibility(View.GONE);
}