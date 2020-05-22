if (savedInstanceState == null) {
    fragA = new FragA();

    FragmentTransaction transaction = manager.beginTransaction();       
    transaction.add(R.id.container, fragA, "TAG_TO_FIND_FRAG_A");
    transaction.commit();           
}
else{
    fragA = manager.findFragmentByTag("TAG_TO_FIND_FRAG_A");

    if(fragA == null){
        // fragA was not attached so the system have not reacreted it
    } else {
        // fragA was attached!
    }
}