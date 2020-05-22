interface HasMember {
    String getMember();
}

abstract class ExceptionWithMember extends Exception implements HasMember{
    String member;

    @Override
    public String getMember() {
        return member;
    }
}

class FooException extends ExceptionWithMember {
}

class BarException extends ExceptionWithMember {
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
    } catch (ExceptionWithMember e) {
        System.out.println(e.getMember());
    }
}