@SpringBootTest
public class ParentOrphanRepositoryTest {

    @Autowired
    private ParentOrphanRepository parentOrphanRepository;

    @Test
    public void testDoubleAdd() {
        addEntity();
        addEntity();
    }

    @Transactional
    public void addEntity() {
        Parent parent = new Parent();
        parent.pid = 1;
        parent.name = "Parent 1";

        parent = parentOrphanRepository.save(parent);


        Child child = new Child();
        List<Child> childList = new ArrayList<>();

        child.parent = parent;
        child.childPK.cid = 1;
        child.name = "Child 1";
        childList.add(child);

        // parent.children.clear(); Not needed.
        parent.children.addAll(childList);
        parentOrphanRepository.save(parent);
        parentOrphanRepository.flush();
    }
}