Test test1 = new Test();
test1.setProp1(1337L);
test1.setProp2(1007L);

/* Do something with test1, including prop2 */

TestReduced test2 = new TestReduced(test1);

/* Do oData stuff with test2, no prop2 anymore */