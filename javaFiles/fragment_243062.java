/**
 * Creates a new map with a default group named 'Default Group'.
 */
public KeyToGroupMap() {
    this("Default Group");
}

/**
 * Creates a new map with the specified default group.
 *
 * @param defaultGroup  the default group (<code>null</code> not permitted).
 */
public KeyToGroupMap(Comparable defaultGroup) {
    if (defaultGroup == null) {
        throw new IllegalArgumentException("Null 'defaultGroup' argument.");
    }
    this.defaultGroup = defaultGroup;
    this.groups = new ArrayList();
    this.keyToGroupMap = new HashMap();
}

/**
 * Returns the number of groups in the map.
 *
 * @return The number of groups in the map.
 */
public int getGroupCount() {
    return this.groups.size() + 1;
}