public void PPL_eve(final PPL_list_wrapper ppl_list_wrapper){
        PPL_wrapper=ppl_list_wrapper;   
        event_details.add(ppl_list_wrapper);//Static ArrayList
        adapter=new ppl_Recycler_Adapter(getActivity(),event_details);
        adapter.notifyDataSetChanged();

    }