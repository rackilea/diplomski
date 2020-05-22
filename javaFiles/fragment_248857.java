private fun setupRecyclerView(){
     binding.tenderList.addItemDecoration(MarginItemDecoration(5))
     adapter = ListTenderAdapter(ListTenderAdapter.OnClickListener {
                    viewModel.displayPropertyDetails(it)
                })
     binding.tenderList.setAdapter(adapter)

}