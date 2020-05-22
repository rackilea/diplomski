public class f_wworks extends Fragment {

private RecyclerView rv_ww;

public void setDataToAdapter(f_ww_Adapter fwa){
   rv_ww.setLayoutManager(new LinearLayoutManager());
   rv_ww.setAdapter(fwa);
}

//all other stuff
}