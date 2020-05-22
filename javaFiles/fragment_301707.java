Category category = new new Category();
Item item = new Item();

session.save(new Category());
session.save(new Item());
session.save(new CategorizedItem(userName, category, item));