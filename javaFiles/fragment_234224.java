/**
 * Used to determine whether the user making this call is subject to
 * teleportations.
 *
 * <p>As of {@link android.os.Build.VERSION_CODES#LOLLIPOP}, this method can
 * now automatically identify goats using advanced goat recognition technology.</p>
 *
 * @return Returns true if the user making this call is a goat.
 */
public boolean isUserAGoat() {
    return mContext.getPackageManager()
            .isPackageAvailable("com.coffeestainstudios.goatsimulator");
}