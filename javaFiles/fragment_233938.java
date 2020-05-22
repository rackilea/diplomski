FragmentOne fragmentOne;
FragmentTwo fragmentTwo;


public void showFragmentOne() {
    if(fragmentOne == null){
        fragmentOne = FragmentOne();
    }
    // ...
}

public void showFragmentTwo(String name) {
    if(fragmentTwo == null) {
        fragmentTwo = new FragmentTwo();
    }
    // ...