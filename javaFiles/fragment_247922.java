// In the parent Activity 

StudentFragment studentFragment;
TeacherFragment teacherFragment;
ParentFragment parentFragment;
Fragment fragmentOnDisplay;

@Override
protected void onCreate(Bundle savedInstanceState) {

   // Initialize fragmentManager, fragmentTransaction, etc.

   studentFragment = (StudentFragment) fragmentManager.findFragmentByTag(Constants.STUDENTPAGE);
   if (studentFragment == null) {
      studentFragment = new StudentFragment ();
      fragmentTransaction.add(R.id.your_frame_layout, studentFragment, Constants.STUDENTPAGE);
   }

   // repeat the same procedure for the other two fragments     

   // Suppose you want to begin with the teacherFragment on 
   // display - in that case hide the studentFragment and 
   // the parentFragment:             

   fragmentTransaction.hide(studentFragment);
   fragmentTransaction.hide(parentFragment);
   fragmentOnDisplay = teacherFragment;
   fragmentTransaction.commit();
}