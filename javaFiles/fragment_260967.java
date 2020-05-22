@Test
public void play(){
    A a = mock(A.class);
    B b = mock(B.class);
    when(a.a("input")).thenReturn(b.b("input"));
}

@Test
public void fix(){
    A a = mock(A.class);
    B b = mock(B.class);
    String returnString = "b";
    when(a.a("input")).thenReturn(returnString);
}

static class A{
    String a(String in){
        return "a";
    }
} 

static class B{
    String b(String in){
        return "b";
    }
}