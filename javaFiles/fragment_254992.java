public Fragment getItem(int position) {
    if (position == 0){
       return new MyFragmentA();
    }else if (position == 1){
       return new MyFragmentB();
    }else { // position == 2
       return new MyFragmentC();
    }
}