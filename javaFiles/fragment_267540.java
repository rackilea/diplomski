if (newEnquiries.getContent() != null && newEnquiries.getContent().size() > 0) {
        Log.i("@sss","OnRes");
        adapter.addAll(newEnquiries.getContent());
        if (currentPage <= TOTAL_PAGES) adapter.addLoadingFooter();
        else isLastPage = true;
    } else {
      //Your else condition
    }