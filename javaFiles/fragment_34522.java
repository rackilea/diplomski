private Map<Instance, Instance> identityMap = new HashMap<>();

public Instance unique(Instance instance) {
    Instance first = identityMap.get(instance);
    if (first == null) {
        first = instance;
        identityMap.put(instance, instance);
    }
    return first;
}

Instance instance = new Instance(i, vals);
instance = unique(instance);