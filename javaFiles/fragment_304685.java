if (ps != null && !ps.codePath.equals(scanFile)) {
    // The path has changed from what was last scanned...  check the
    // version of the new path against what we have stored to determine
    // what to do.
    if (pkg.mVersionCode < ps.versionCode) {
        // The system package has been updated and the code path does not match
        // Ignore entry. Skip it.
        ......
    } else {
        ......
    }
    ......
}