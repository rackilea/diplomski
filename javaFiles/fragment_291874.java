/**
 * Queue of suspended threads to choose from when needing
 * to select a thread when another is resumed. Threads
 * are added in the order they suspend.
 */
private Set fThreadQueue = new LinkedHashSet();