// This is how you create a hash map:
HashMap<String,Member> members = new HashMap<String,Member>();

// This is how you add an object to it. It is slower than lists,
// but since reading happens far often, it pays off.
members.put("ben", new Member());

// This is how you access an object in the hash map.
// Accessing a hash map is O(1).
Member member = members.get("ben");

// This is how you remove an object from the hash map.
// Removing an object is also O(1)
members.remove("ben");

// Hash maps are also iterable
for(Member member : members.values()) {
}