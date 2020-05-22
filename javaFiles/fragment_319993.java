public class CollegeBulletinListFragment extends Fragment implements OnClickListener, Connector.OnPostExecuteListener {

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       Connector connect= new Connector(getActivity().getApplicationContext(),colval,secondFlag);
       connect.setOnPostExecuteListener(this); // set callback listener
       connect.execute("");
   }

   @Override
   public void onPostExecute(String result){
      // do something with onPostExecute result.
   }

}