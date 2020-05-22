@After(order = 500)
public void tearDown(Scenario scenario) {

}

@After(value = "@DeleteUserAfterTest", order = 1000)
public void deleteUser(){

}