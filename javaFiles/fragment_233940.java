public class FragmentStateChanger {
    private FragmentManager fragmentManager;
    private int containerId;

    public FragmentStateChanger(FragmentManager fragmentManager, int containerId) {
        this.fragmentManager = fragmentManager;
        this.containerId = containerId;
    }

    public void handleStateChange(StateChange stateChange) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.disallowAddToBackStack();

        // here you could animate based on direction
        List<Key> previousKeys = stateChange.getPreviousKeys();
        List<Key> newKeys = stateChange.getNewKeys();
        for(Key oldKey : previousKeys) {
            Fragment fragment = fragmentManager.findFragmentByTag(oldKey.getFragmentTag());
            if(fragment != null) {
                if(!newState.contains(oldKey)) {
                    fragmentTransaction.remove(fragment);
                } else if(!fragment.isDetached()) {
                    fragmentTransaction.detach(fragment);
                }
            }
        }
        for(Key newKey : newKeys) {
            Fragment fragment = fragmentManager.findFragmentByTag(newKey.getFragmentTag());
            if(newKey.equals(stateChange.topNewKey())) {
                if(fragment != null) {
                    if(fragment.isRemoving()) {
                        fragment = newKey.createFragment();
                        fragmentTransaction.replace(containerId, fragment, newKey.getFragmentTag());
                    } else if(fragment.isDetached()) {
                        fragmentTransaction.attach(fragment);
                    }
                } else {
                    fragment = newKey.createFragment();
                    fragmentTransaction.add(containerId, fragment, newKey.getFragmentTag());
                }
            } else {
                if(fragment != null && !fragment.isDetached()) {
                    fragmentTransaction.detach(fragment);
                }
            }
        }
        fragmentTransaction.commitAllowingStateLoss();
    }
}