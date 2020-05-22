public TestGroupEntity(UserEntity owner, Set<TestEntity> tests) {
        this.owner = owner;
        owner.constructInit(this); 
        this.tests = tests;
        tests.stream().forEach(t -> t.constructInit(this));  
    }

public class UserEntity {

    private TestGroupEntity testGroupEntity;

    public void constructInit(TestGroupEntity testGroupEntity) {
      if (this.testGroupEntity != null) {
        throw new IllegalArgumentException("forbidden");
      }
      this.testGroupEntity=testGroupEntity;
    }

}