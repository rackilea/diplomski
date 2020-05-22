try {
    t.foo = "bar";
    doSomethingRiskyWhichMightThrowMyException();
} catch(MyException e) {
    t.foo = "rolledbackvalue";
}