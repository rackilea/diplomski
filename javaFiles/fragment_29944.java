@Navigator.Name("sticky_fragment")
public class StickyFragmentNavigator extends Navigator<StickyFragmentNavigator.Destination> {


    private static final String TAG = "StickyFragmentNavigator";
    private static final String KEY_BACK_STACK_IDS = "androidx-nav-fragment:navigator:backStackIds";

    private final Context mContext;
    @SuppressWarnings("WeakerAccess") /* synthetic access */
    final FragmentManager mFragmentManager;
    private final int mContainerId;
    @SuppressWarnings("WeakerAccess") /* synthetic access */
            ArrayDeque<Integer> mBackStack = new ArrayDeque<>();
    @SuppressWarnings("WeakerAccess") /* synthetic access */
            boolean mIsPendingBackStackOperation = false;

    private final FragmentManager.OnBackStackChangedListener mOnBackStackChangedListener =
            new FragmentManager.OnBackStackChangedListener() {

                @SuppressLint("RestrictedApi")
                @Override
                public void onBackStackChanged() {
                    // If we have pending operations made by us then consume this change, otherwise
                    // detect a pop in the back stack to dispatch callback.
                    if (mIsPendingBackStackOperation) {
                        mIsPendingBackStackOperation = !isBackStackEqual();
                        return;
                    }

                    // The initial Fragment won't be on the back stack, so the
                    // real count of destinations is the back stack entry count + 1
                    int newCount = mFragmentManager.getBackStackEntryCount() + 1;
                    if (newCount < mBackStack.size()) {
                        // Handle cases where the user hit the system back button
                        while (mBackStack.size() > newCount) {
                            mBackStack.removeLast();
                        }
                        dispatchOnNavigatorBackPress();
                    }
                }
            };

    public StickyFragmentNavigator(@NonNull Context context, @NonNull FragmentManager manager,
                           int containerId) {
        mContext = context;
        mFragmentManager = manager;
        mContainerId = containerId;
    }

    @Override
    protected void onBackPressAdded() {
        mFragmentManager.addOnBackStackChangedListener(mOnBackStackChangedListener);
    }

    @Override
    protected void onBackPressRemoved() {
        mFragmentManager.removeOnBackStackChangedListener(mOnBackStackChangedListener);
    }

    @Override
    public boolean popBackStack() {
        if (mBackStack.isEmpty()) {
            return false;
        }
        if (mFragmentManager.isStateSaved()) {
            Log.i(TAG, "Ignoring popBackStack() call: FragmentManager has already"
                    + " saved its state");
            return false;
        }
        if (mFragmentManager.getBackStackEntryCount() > 0) {
            mFragmentManager.popBackStack(
                    generateBackStackName(mBackStack.size(), mBackStack.peekLast()),
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);
            mIsPendingBackStackOperation = true;
        } // else, we're on the first Fragment, so there's nothing to pop from FragmentManager
        mBackStack.removeLast();
        return true;
    }

    @NonNull
    @Override
    public StickyFragmentNavigator.Destination createDestination() {
        return new StickyFragmentNavigator.Destination(this);
    }

    @NonNull
    public Fragment instantiateFragment(@NonNull Context context,
                                        @SuppressWarnings("unused") @NonNull FragmentManager fragmentManager,
                                        @NonNull String className, @Nullable Bundle args) {
        return Fragment.instantiate(context, className, args);
    }

    @Nullable
    @Override
    public NavDestination navigate(@NonNull StickyFragmentNavigator.Destination destination, @Nullable Bundle args,
                                   @Nullable NavOptions navOptions, @Nullable Navigator.Extras navigatorExtras) {
        if (mFragmentManager.isStateSaved()) {
            Log.i(TAG, "Ignoring navigate() call: FragmentManager has already"
                    + " saved its state");
            return null;
        }
        String className = destination.getClassName();
        if (className.charAt(0) == '.') {
            className = mContext.getPackageName() + className;
        }

        final FragmentTransaction ft = mFragmentManager.beginTransaction();

        int enterAnim = navOptions != null ? navOptions.getEnterAnim() : -1;
        int exitAnim = navOptions != null ? navOptions.getExitAnim() : -1;
        int popEnterAnim = navOptions != null ? navOptions.getPopEnterAnim() : -1;
        int popExitAnim = navOptions != null ? navOptions.getPopExitAnim() : -1;
        if (enterAnim != -1 || exitAnim != -1 || popEnterAnim != -1 || popExitAnim != -1) {
            enterAnim = enterAnim != -1 ? enterAnim : 0;
            exitAnim = exitAnim != -1 ? exitAnim : 0;
            popEnterAnim = popEnterAnim != -1 ? popEnterAnim : 0;
            popExitAnim = popExitAnim != -1 ? popExitAnim : 0;
            ft.setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim);
        }

        String tag = Integer.toString(destination.getId());
        Fragment primaryNavigationFragment = mFragmentManager.getPrimaryNavigationFragment();
        if(primaryNavigationFragment != null)
            ft.hide(primaryNavigationFragment);
        Fragment destinationFragment = mFragmentManager.findFragmentByTag(tag);
        if(destinationFragment == null) {
            destinationFragment = instantiateFragment(mContext, mFragmentManager, className, args);
            destinationFragment.setArguments(args);
            ft.add(mContainerId, destinationFragment , tag);
        }
        else
            ft.show(destinationFragment);

        ft.setPrimaryNavigationFragment(destinationFragment);

        final @IdRes int destId = destination.getId();
        final boolean initialNavigation = mBackStack.isEmpty();
        // TODO Build first class singleTop behavior for fragments
        final boolean isSingleTopReplacement = navOptions != null && !initialNavigation
                && navOptions.shouldLaunchSingleTop()
                && mBackStack.peekLast() == destId;

        boolean isAdded;
        if (initialNavigation) {
            isAdded = true;
        } else if (isSingleTopReplacement) {
            // Single Top means we only want one instance on the back stack
            if (mBackStack.size() > 1) {
                // If the Fragment to be replaced is on the FragmentManager's
                // back stack, a simple replace() isn't enough so we
                // remove it from the back stack and put our replacement
                // on the back stack in its place
                mFragmentManager.popBackStackImmediate(
                        generateBackStackName(mBackStack.size(), mBackStack.peekLast()), 0);
                mIsPendingBackStackOperation = false;
            }
            isAdded = false;
        } else {
            ft.addToBackStack(generateBackStackName(mBackStack.size() + 1, destId));
            mIsPendingBackStackOperation = true;
            isAdded = true;
        }
        if (navigatorExtras instanceof FragmentNavigator.Extras) {
            FragmentNavigator.Extras extras = (FragmentNavigator.Extras) navigatorExtras;
            for (Map.Entry<View, String> sharedElement : extras.getSharedElements().entrySet()) {
                ft.addSharedElement(sharedElement.getKey(), sharedElement.getValue());
            }
        }
        ft.setReorderingAllowed(true);
        ft.commit();
        // The commit succeeded, update our view of the world
        if (isAdded) {
            mBackStack.add(destId);
            return destination;
        } else {
            return null;
        }
    }

    @Override
    @Nullable
    public Bundle onSaveState() {
        Bundle b = new Bundle();
        int[] backStack = new int[mBackStack.size()];
        int index = 0;
        for (Integer id : mBackStack) {
            backStack[index++] = id;
        }
        b.putIntArray(KEY_BACK_STACK_IDS, backStack);
        return b;
    }

    @Override
    public void onRestoreState(@Nullable Bundle savedState) {
        if (savedState != null) {
            int[] backStack = savedState.getIntArray(KEY_BACK_STACK_IDS);
            if (backStack != null) {
                mBackStack.clear();
                for (int destId : backStack) {
                    mBackStack.add(destId);
                }
            }
        }
    }

    @NonNull
    private String generateBackStackName(int backStackIndex, int destId) {
        return backStackIndex + "-" + destId;
    }

    private int getDestId(@Nullable String backStackName) {
        String[] split = backStackName != null ? backStackName.split("-") : new String[0];
        if (split.length != 2) {
            throw new IllegalStateException("Invalid back stack entry on the "
                    + "NavHostFragment's back stack - use getChildFragmentManager() "
                    + "if you need to do custom FragmentTransactions from within "
                    + "Fragments created via your navigation graph.");
        }
        try {
            // Just make sure the backStackIndex is correctly formatted
            Integer.parseInt(split[0]);
            return Integer.parseInt(split[1]);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Invalid back stack entry on the "
                    + "NavHostFragment's back stack - use getChildFragmentManager() "
                    + "if you need to do custom FragmentTransactions from within "
                    + "Fragments created via your navigation graph.");
        }
    }

    @SuppressWarnings("WeakerAccess") /* synthetic access */
    boolean isBackStackEqual() {
        int fragmentBackStackCount = mFragmentManager.getBackStackEntryCount();
        // Initial fragment won't be on the FragmentManager's back stack so +1 its count.
        if (mBackStack.size() != fragmentBackStackCount + 1) {
            return false;
        }

        // From top to bottom verify destination ids match in both back stacks/
        Iterator<Integer> backStackIterator = mBackStack.descendingIterator();
        int fragmentBackStackIndex = fragmentBackStackCount - 1;
        while (backStackIterator.hasNext() && fragmentBackStackIndex >= 0) {
            int destId = backStackIterator.next();
            try {
                int fragmentDestId = getDestId(mFragmentManager
                        .getBackStackEntryAt(fragmentBackStackIndex--)
                        .getName());
                if (destId != fragmentDestId) {
                    return false;
                }
            } catch (NumberFormatException e) {
                throw new IllegalStateException("Invalid back stack entry on the "
                        + "NavHostFragment's back stack - use getChildFragmentManager() "
                        + "if you need to do custom FragmentTransactions from within "
                        + "Fragments created via your navigation graph.");
            }
        }

        return true;
    }

    @NavDestination.ClassType(Fragment.class)
    public static class Destination extends NavDestination {

        private String mClassName;

        public Destination(@NonNull NavigatorProvider navigatorProvider) {
            this(navigatorProvider.getNavigator(StickyFragmentNavigator.class));
        }

        public Destination(@NonNull Navigator<? extends StickyFragmentNavigator.Destination> fragmentNavigator) {
            super(fragmentNavigator);
        }

        @CallSuper
        @Override
        public void onInflate(@NonNull Context context, @NonNull AttributeSet attrs) {
            super.onInflate(context, attrs);
            TypedArray a = context.getResources().obtainAttributes(attrs,
                    R.styleable.FragmentNavigator);
            String className = a.getString(R.styleable.FragmentNavigator_android_name);
            if (className != null) {
                setClassName(className);
            }
            a.recycle();
        }

        @NonNull
        public final StickyFragmentNavigator.Destination setClassName(@NonNull String className) {
            mClassName = className;
            return this;
        }

        @NonNull
        public final String getClassName() {
            if (mClassName == null) {
                throw new IllegalStateException("Fragment class was not set");
            }
            return mClassName;
        }
    }

    public static final class Extras implements Navigator.Extras {
        private final LinkedHashMap<View, String> mSharedElements = new LinkedHashMap<>();

        Extras(Map<View, String> sharedElements) {
            mSharedElements.putAll(sharedElements);
        }

        @NonNull
        public Map<View, String> getSharedElements() {
            return Collections.unmodifiableMap(mSharedElements);
        }

        public static final class Builder {
            private final LinkedHashMap<View, String> mSharedElements = new LinkedHashMap<>();

            @NonNull
            public StickyFragmentNavigator.Extras.Builder addSharedElements(@NonNull Map<View, String> sharedElements) {
                for (Map.Entry<View, String> sharedElement : sharedElements.entrySet()) {
                    View view = sharedElement.getKey();
                    String name = sharedElement.getValue();
                    if (view != null && name != null) {
                        addSharedElement(view, name);
                    }
                }
                return this;
            }

            @NonNull
            public StickyFragmentNavigator.Extras.Builder addSharedElement(@NonNull View sharedElement, @NonNull String name) {
                mSharedElements.put(sharedElement, name);
                return this;
            }

            @NonNull
            public StickyFragmentNavigator.Extras build() {
                return new StickyFragmentNavigator.Extras(mSharedElements);
            }
        }
    }
}