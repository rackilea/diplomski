final Set<String> desktopMediaCodes = getCodesByMediaDeviceType(mediaModels, MediaDeviceType.DESKTOP);
final Set<String> mobileMediaCodes = getCodesByMediaDeviceType(mediaModels, MediaDeviceType.MOBILE);
final Set<String> tabletMediaCodes = getCodesByMediaDeviceType(mediaModels, MediaDeviceType.TABLET);

// In case they are the same, only default.
if (desktopMediaCodes.equals(mobileMediaCodes) && mobileMediaCodes.equals(tabletMediaCodes)) {
    asset.setDefaults(desktopMediaCodes);
    return;
}

// In case three are different, we will send mobile, desktop and tablet.
if (!desktopMediaCodes.equals(mobileMediaCodes) && !desktopMediaCodes.equals(tabletMediaCodes) && !mobileMediaCodes.equals(tabletMediaCodes)) {
    asset.setDesktop(desktopMediaCodes);
    asset.setMobile(mobileMediaCodes);
    asset.setTablet(tabletMediaCodes);
    return;
}

// In case only tablet is different, we will send default and tablet.
if (desktopMediaCodes.equals(mobileMediaCodes)) {
    asset.setDefaults(desktopMediaCodes);
    asset.setTablet(tabletMediaCodes);
    return;
}

// In case only desktop is different, we will send default and tablet.
if (mobileMediaCodes.equals(tabletMediaCodes)) {
    asset.setDefaults(mobileMediaCodes);
    asset.setDesktop(desktopMediaCodes);
    return;
}

// In case only mobile is different, we will send default and tablet.
asset.setDefaults(tabletMediaCodes);
asset.setMobile(mobileMediaCodes);