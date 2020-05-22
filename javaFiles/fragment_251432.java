import com.google.common.collect.ImmutableSet

// ...
Set<Integer> newSet = new ImmutableSet.Builder<Integer>()
                                .addAll(oldSet)
                                .add(3)
                                .build();