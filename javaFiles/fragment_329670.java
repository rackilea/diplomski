class TestDAO{

@Autowired
TestRepo testRepo;

public void saveTest(Test test) {
testRepo.save(test);
}