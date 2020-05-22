Map<Integer, String> imageMap = new HashMap<Integer, String>
// Put the other ones here.
imageMap.put(R.drawable.bengalTiger, "bengaltiger");
.
.
.

// Later on, use them like this:
for(Integer id : imageMap.keyset()) {
  String name = imageMap.get(id);
  // You can now use "id" and "name" in whatever UI elements you want.
}