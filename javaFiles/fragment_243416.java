interface HasMember {
    String getMember();
}

class FooException extends Exception implements HasMember {
    public String member;

    @Override
    public String getMember() {
        return member;
    }
}

class BarException extends Exception implements HasMember {
    public String member;

    @Override
    public String getMember() {
        return member;
    }
}

void throwFoo () throws FooException {
    throw new FooException();
}

void throwBar () throws BarException {
    throw new BarException();
}

public void test(String[] args) throws Exception {
    try {
        throwFoo();
        throwBar();
    } catch (FooException|BarException e) {
        System.out.println(e.getMember());
    }
}