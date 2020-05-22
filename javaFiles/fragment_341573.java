public void showFragB() {
    fragB = new FragB();

    // this line will force the system to recreate fragA,
    // if fragB is recreated;
    fragB.setTargetFragment(fragA, 0);  

    FragmentTransaction transaction = manager.beginTransaction(); 

    // I assumed fragA here is just a typo (it should be fragB)      
    transaction.replace(R.id.container, fragA);
    transaction.commit();
}