@Component
class SomeUnfortunateClient {
    // I know field injection is evil!
    @Autowired TestRepository testRepository;

    void youAreGoingToBeSurprised() {
        testRepository.printTest();
    }
}