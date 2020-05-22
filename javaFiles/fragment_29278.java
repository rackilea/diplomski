Like you had done in R.id.club you can open other fragments on click of R.id.poi or R.id.Calendal
Fragment newFragment = new ABC(); 
    FragmentTransaction transaction = getFragmentManager().beginTransaction();
    transaction.replace(R.id.fragment_container, newFragment);
    transaction.addToBackStack(null);

    // Commit the transaction
    transaction.commit();