public class FragmentA extends ListFragment implements onListItemSelectedListener, onItemClickListener{

OnListItemSelectedListener mListener;

   //onCreateView blah blah blah



 // Container Activity must implement this interface
    public interface OnListItemSelectedListener {
    public void onListItemSelected(int position);
}


}


  @Override
  public void onAttach(Activity activity) {
    super.onAttach(activity);

    // This makes sure that the container activity has implemented
    // the callback interface. If not, it throws an exception
    try {
        mListener = (OnListItemSelectedListener) activity;
    } catch (ClassCastException e) {
        throw new ClassCastException(activity.toString()
                + " must implement OnListItemSelectedListener");
    }
}


  @Override 
 public void onItemClick(AdapterView<?> parent, View view, int position, long id){


 //Here's where you would get the position of the item selected in the list, and  pass    that position(and whatever other data you need to) up to the activity 
//by way of the interface you defined in onAttach

  mListener.onListItemSelected(position);


}