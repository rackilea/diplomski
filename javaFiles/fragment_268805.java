// Don't use synchronizedMap
// private Map<Integer, MyResource> resources = Collections.synchronizedMap(new HashMap<Integer, MyResource>());

private Map<Integer, MyResource> resources = new ConcurrentHashMap<>();

public void addResource(MyResource r) {
    resources.put(r.getId(), r);
}

public void removeResource(int id) {
    resources.remove(id);
}

public Map<Integer, MyResource> getResources() {
    return Collections.unmodifiableMap(resources);
}