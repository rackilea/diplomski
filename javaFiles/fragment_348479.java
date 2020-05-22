boolean success = false;
if (credential.getExpiresInSeconds() <= 60) {
    if (credential.refreshToken()) {
        success = true;
    }
} else {
    success = true;
}