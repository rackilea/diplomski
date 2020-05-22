@NotNull
public static Thing fromMe(@NotNull final String id) {
    // Keep track of the thing I've created (if any)
    // Use AtomicReference as a mutable final.
    // NB: Also delays GC as a hard reference is held.
    final AtomicReference<Thing> thing = new AtomicReference<>();
    // Make the map entry if not exists.
    INSTANCES.computeIfAbsent(id,
            // New one only made if not present.
            r -> new WeakReference<>(newThing(thing, id)));

    // Grab it - whatever it's contents.
    // NB: Parallel deletions will cause a NPE here.
    trackThing(thing, INSTANCES.get(id).get());
    // Has it been GC'd
    if (thing.get() == null) {
        // Make it again!
        INSTANCES.put(id, new WeakReference<>(newThing(thing, id)));
    }

    return thing.get();
}

// Makes a new Thing - keeping track of the new one in the reference.
static Thing newThing(AtomicReference<Thing> thing, String id) {
    // Make the new Thing.
    return trackThing(thing, new Thing(id));
}

// Tracks the Thing in the Atomic.
static Thing trackThing(AtomicReference<Thing> thing, Thing it) {
    // Keep track of it.
    thing.set(it);
    return it;
}