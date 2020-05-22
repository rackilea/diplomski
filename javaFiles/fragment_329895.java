/**
 * Create a new tree filter for a user supplied path.
 * <p>
 * Path strings are relative to the root of the repository. If the user's
 * input should be assumed relative to a subdirectory of the repository the
 * caller must prepend the subdirectory's path prior to creating the filter.
 * <p>
 * Path strings use '/' to delimit directories on all platforms.
 *
 * @param path
 *            the path to filter on. Must not be the empty string. All
 *            trailing '/' characters will be trimmed before string's length
 *            is checked or is used as part of the constructed filter.
 * @return a new filter for the requested path.
 * @throws IllegalArgumentException
 *             the path supplied was the empty string.
 */
public static PathFilter create(String path) { ... }