binding.tenderList.addItemDecoration(MarginItemDecoration(5))

                    val adapter=binding.tenderList.adapter as ListTenderAdapter
                    adapter.submitList(viewModel.response.value)
                    binding.tenderList.adapter = ListTenderAdapter(ListTenderAdapter.OnClickListener {
                        viewModel.displayPropertyDetails(it)
                    })
                    adapter.notifyDataSetChanged()