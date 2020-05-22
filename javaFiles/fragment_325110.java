@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CtThhlastikaPressThreatsRepositoryImplTest {

    @Autowired
    private CtThhlastikaPressThreatsRepository ctThhlastikaPressThreatsRepository;

    @Test
    public void findByIdTest() {
        CtThhlastikaPressThreats pressThreats = new CtThhlastikaPressThreats();
        pressThreats.setActCode("actcode");
        pressThreats.setDescriptionEn("description");
        pressThreats.setRemarks("remarks");
        ctThhlastikaPressThreatsRepository.save(pressThreats);

        CtThhlastikaPressThreats found = ctThhlastikaPressThreatsRepository.findById(pressThreats.getId()).orElse(null);
        assertEquals("description", found.getDescriptionEn());

        CtThhlastikaPressThreats found2 = ctThhlastikaPressThreatsRepository.findCtThhlastikaPressThreatsById(pressThreats.getId());
        assertEquals("description", found2.getDescriptionEn());
    }

    @Test
    public void listCodesTest() {
        CtThhlastikaPressThreats pressThreats = new CtThhlastikaPressThreats();
        pressThreats.setActCode("actcode1");
        pressThreats.setDescriptionEn("description1");
        pressThreats.setRemarks("remarks1");
        ctThhlastikaPressThreatsRepository.save(pressThreats);
        pressThreats = new CtThhlastikaPressThreats();
        pressThreats.setActCode("actcode2");
        pressThreats.setDescriptionEn("description2");
        pressThreats.setRemarks("remarks2");
        ctThhlastikaPressThreatsRepository.save(pressThreats);
        List<String> expected = Arrays.asList(new String[] {"actcode1", "actcode2"});

        ArrayList<String> found = ctThhlastikaPressThreatsRepository.findDistinctByActCodeOrderByActCode();
        assertTrue(found.containsAll(expected) && expected.containsAll(found));
    }
}