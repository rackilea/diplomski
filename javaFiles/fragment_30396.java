public class MyFragmentB extends Fragment {

   ...

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) 
   {
      View view = inflater.inflate(R.layout.fragment_both, container, false);
      TextView x = (TextView)view.findViewById(R.id.textView);
      x.setText("I am fragment B");
      return view;
   }
...