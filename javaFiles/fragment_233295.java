// list = [<Pointer>, E1, E2, E3] -- next=E1, previous=exception
assertEquals(E1, next());
// list = [E1, <Pointer>, E2, E3] -- next=E2, previous=E1
assertEquals(E2, next());
// list = [E1, E2, <Pointer>, E3] -- next=E3, previous=E2
assertEquals(E3, next());
// list = [E1, E2, E3, <Pointer>] -- next=exception, previous=E3
assertEquals(E3, previous());
// list = [E1, E2, <Pointer>, E3] -- next=E3, previous=E2
assertEquals(E2, previous());
// list = [E1, <Pointer>, E2, E3] -- next=E2, previous=E1
assertEquals(E1, previous());
// list = [<Pointer>, E1, E2, E3] -- next=E1, previous=exception