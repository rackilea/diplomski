public class ContainerDaoTest extends BaseDaoTest {

    @Test
    public void testSaveEntityA() {

        ContainerA c = new ContainerA();

        BinaryData b = new BinaryData();
        c.setBinaryData(b);

        ContainerDao dao = new ContainerDao();
        dao.persist(c);

        c = dao.load(c.getId());
        Assert.assertEquals(c.getId(), b.getContainer().getId());
    }

    @Test
    public void testLoadEntity() {
        ContainerA c = new ContainerDao().load(2l);
        Assert.assertEquals(new Long(3), c.getBinaryData().getId());
        Assert.assertEquals(new Long(2), c.getBinaryData().getContainer().getId());
        Assert.assertEquals("container_a", c.getBinaryData().getContainerClass());
    }

    @Override
    protected String[] getDataSetPaths() {
        return new String[] { "/stack/container.xml", "/stack/binarydata.xml" };
    }
}