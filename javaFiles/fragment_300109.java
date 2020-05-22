@Component
public class NewClass {
    final SomeObjectRepository2 someObjectRepository2;

    @Autowired
    public NewClass(final SomeObjectRepository2 someObjectRepository2) {
        this.someObjectRepository2 = someObjectRepository2;
    }

    @Transactional(isolation = Propagation.REQUIRES_NEW) // enforces new transaction
    public WhateverNeedsToBereturned newMethod(WhateverType someObject) {
        return someObjectRepository2.create(someObj);
    }
}