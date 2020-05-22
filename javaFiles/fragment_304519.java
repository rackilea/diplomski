/**
 * A {@link Predicate} that checks whether a class exists in the given {@link HeapDump}
 */
public class ClassExistsPredicate implements Predicate<String> {

    private final HeapDump heapDump;

    public ClassExistsPredicate(HeapDump heapDump) {
        this.heapDump = heapDump;
    }

    @Override
    public boolean apply(String fullyQualifiedClassName) {
        // checks whether the given class exists in the heap dump
        return true;
    }

}


public enum GuavaVersion {

    R01,

    R02 {
        @Override
        Set<String> getAddedClasses() {
            return ImmutableSet.of("com.google.common.base.Foo");
        }
    },

    R03 {
        @Override
        Set<String> getAddedClasses() {
            return ImmutableSet.of("com.google.common.collect.ForwardingFooIterator");
        }
    },

    R04 {
        @Override
        Set<String> getAddedClasses() {
            return ImmutableSet.of("com.google.common.collect.FooFoo2");
        }
    };

    /**
     * @return a {@link Set} of added class names that uniquely identify this version from the preceding one (not
     *         necessarily <b>all</b> classes!)
     */
    Set<String> getAddedClasses() {
        return ImmutableSet.of();
    }

    public static GuavaVersion getGuavaVersionFor(HeapDump heapDump) {
        ClassExistsPredicate classExists = new ClassExistsPredicate(heapDump);

        for (GuavaVersion version : Lists.reverse(Arrays.asList(GuavaVersion.values()))) {
            if (Iterables.all(version.getAddedClasses(), classExists)) {
                return version;
            }
        }

        throw new RuntimeException("Unable to determine Guava version...");
    }

}