/**
 * After the FileProvider is instantiated, this method is called to provide the system with
 * information about the provider.
 *
 * @param context A {@link Context} for the current component.
 * @param info A {@link ProviderInfo} for the new provider.
 */
@Override
public void attachInfo(Context context, ProviderInfo info) {
    super.attachInfo(context, info);

    // Sanity check our security
    if (info.exported) {
        throw new SecurityException("Provider must not be exported");
    }
    if (!info.grantUriPermissions) {
        throw new SecurityException("Provider must grant uri permissions");
    }

    mStrategy = getPathStrategy(context, info.authority);
}