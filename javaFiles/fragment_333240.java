// Failures can happen 
void add(key, value) throws AlreadyOnMapException

// Update if already on list
void insert(key, value);

// Make available Contains() methods to control the flow by avoiding exceptions
boolean containsKey(key);

boolean containsValue(value);