@RunWith(PowerMockRunner.class)
@PrepareForTest({EntityController.class})
public class SomeTest {

    @Test
    public void aTest() {
        PowerMockito.mockStatic(EntityController.class);

        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Mockito.when(EntityController.getEntityManager()).thenReturn(entityManager);

        TypedQuery<ExamSkeleton> query = (TypedQuery<ExamSkeleton>) Mockito.mock(TypedQuery.class);

        Mockito.when(entityManager.createQuery("SELECT NEW ExamSkeleton (s.id, s.filename, s.course, s.visible) FROM ExamSkeleton as s")).thenReturn(query);

        List<ExamSkeleton> expected = new ArrayList<>();
        Mockito.when(query.getResultList()).thenReturn(expected);

        ExamRepository examRepository = new ExamRepository();

        List<ExamSkeletons> actual = examRepository.getAllSkeletons();

        // this assertion verifies that getAllSkeletons gives you the result of the above SQl query
        assertSame(expected, actual);
    }
}