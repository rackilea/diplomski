Transaction tx = session.beginTransaction()

child.setParent(parent);
session.saveOrUpdate(child);
parent.getChildren().add(child);

tx.commit()