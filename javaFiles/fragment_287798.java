final Item parent = new Item();
final Item child = new Item();
child.setSlot(3);
child.setParent(parent);

final HashMap<Integer, Item> children = new HashMap<Integer, Item>();
children.put(child.getParentKey(), child);
parent.setChildren(children);

session.save(child);
session.save(parent);