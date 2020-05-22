@Override
public Fragment getItem( int position ) {

    if( mRosterUids == null || mRosterUids.size() <= position )
        return null;
    Log.e( "RosterDetailsPagerAdapter", "getItem(): " + mRosterUids.get(position) );
    return getRosterDetailsFragment( mRosterUids.get(position) );
}

public SLRosterDetailsFragment getRosterDetailsFragment( String uid ) {
    return SLRosterDetailsFragment.newInstance( uid );
}