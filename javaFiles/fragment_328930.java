/**
 * A certificate chain cleaner that uses a set of trusted root certificates to build the trusted
 * chain. This class duplicates the clean chain building performed during the TLS handshake. We
 * prefer other mechanisms where they exist, such as with
 * {@code okhttp3.internal.platform.AndroidPlatform.AndroidCertificateChainCleaner}.
 *
 * <p>This class includes code from <a href="https://conscrypt.org/">Conscrypt's</a> {@code
 * TrustManagerImpl} and {@code TrustedCertificateIndex}.
 */