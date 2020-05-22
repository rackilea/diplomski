public interface ArithmaticResource {

@Get("json?n0&n1")
public int add ();

@Get("json?n0&n1&n2")
public int add ();
}