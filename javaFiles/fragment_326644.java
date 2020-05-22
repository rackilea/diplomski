// assert that the number of found <option> elements matches the expectations
assertEquals(exp.length, allOptions.size());
// assert that the value of every <option> element equals the expected value
for (int i = 0; i < exp.length; i++) {
    assertEquals(exp[i], allOptions.get(i).getAttribute("value"));
}