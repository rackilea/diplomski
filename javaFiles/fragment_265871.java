if(getSupportFragmentManager().getFragments() != null) {
    for (Fragment fragment : getSupportFragmentManager().getFragments())
    {
        if (fragment instanceof ChallongePlayers) {
            ((ChallongePlayers) fragment).swipe_container.setRefreshing(true);
        } else if (fragment instanceof ChallongeMatches) {
            ((ChallongeMatches) fragment).swipe_container.setRefreshing(true);
        }
    }
}