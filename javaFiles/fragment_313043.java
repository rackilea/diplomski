public aspect ObjectCreationAspect {
    before() : preinitialization(*.new(..)) && !within(ObjectCreationAspect) {
        System.out.println(thisJoinPointStaticPart);
    }

    before() : initialization(*.new(..)) && !within(ObjectCreationAspect) {
        System.out.println(thisJoinPointStaticPart);
    }

    before() : call(*.new(..)) && !within(ObjectCreationAspect) {
        System.out.println(thisJoinPointStaticPart);
    }

    before() : execution(*.new(..)) && !within(ObjectCreationAspect) {
        System.out.println(thisJoinPointStaticPart);
    }
}