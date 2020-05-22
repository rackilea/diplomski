@Override
public void onClick(View v) {
// when law1 till law11 clicked, go to ExplainLawFragment.java to view fragment_explain_law.xml
Fragment fragment = null;
String title = null;

switch (v.getId()) {
case R.id.law1:
    // view explainLaw
    fragment = new ExplainLawFragment();
    title = "Copyright Act (Amendment) 1997";
 FragmentManager fragmentManager = getFragmentManager();
FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
fragmentTransaction.replace(R.id.container, fragment);
fragmentTransaction.addToBackStack(null);
fragmentTransaction.commit();
    break;