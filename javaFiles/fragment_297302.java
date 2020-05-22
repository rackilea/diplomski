private Helper mHelper;

@Override
public void onAttach(Activity activity){
   super.onAttach (activity);
   mHelper = new Helper (activity);
}