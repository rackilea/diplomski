for (Child child : parent.getChildren()) {
    // Have to run a find since the entities are detached
    Child c = entityManager.find(Child.class, child.getId());
    parent.getChildren().remove(c); // ensure that the child is actually removed
    entityManager.remove(c);
}