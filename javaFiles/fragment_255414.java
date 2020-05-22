@Autowired
private ParentDao parentDao;

. . . createChild() {
    Child child = new Child();
    // Set the link on both sides of the relationship
    parent.addChild(child);
    Parent newParent = parentDao.update(parent);
    // --> newParent.getChildren(0).getId() == 0
}