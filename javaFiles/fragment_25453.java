//Declare the Calendar in your test method
Calendar cal = Calendar.getInstance();
cal.setTimeInMillis(0l);

//receive the calendar to be used in testedClass constructor
public void testedMethod() {
    ...
    if (doSomething(cal.getTime())) {
    ...
}

//use the same calendar to make the assertion
public void testThatMethod() {
    ...
    expect(testedClass.(testedMethod(cal.getTime())).andReturn(false);
    ...
}