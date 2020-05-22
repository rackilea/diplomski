/**
 * Replace an existing fragment that was added to a container.  This is
 * essentially the same as calling {@link #remove(Fragment)} for all
 * currently added fragments that were added with the same containerViewId
 * and then {@link #add(int, Fragment, String)} with the same arguments
 * given here.
**/
public abstract FragmentTransaction replace(@IdRes int containerViewId, Fragment fragment,
        String tag)