Identifiable ob1 = new Identifiable();
ob1.value = 13;
Identifiable ob2 = new Identifiable();
ob2.value = 42;
// link as a cycle:
ob1.next = ob2;
ob2.next = ob1;