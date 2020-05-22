@OneToMany (cascade = CascadeType.ALL, mappedBy = "parent")
@MapKey(name="id")
Map<Long, Item> children = new HashMap<Integer, Item>();

...

final Item parent = new Item();

final Item child = new Item();
child.setParent(parent);
em.persist(child);
em.flush(); // Force child's 'id' to be generated & populated

final HashMap<Integer, Item> children = new HashMap<Integer, Item>();
children.put(child.getId(), child);
parent.setChildren(children);

em.persist(parent);