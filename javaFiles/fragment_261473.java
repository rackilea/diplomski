Depth: 0
Node{id='A', child=Node{id='B', child=Node{id='C', child=Node{id='D', child=null}}}} => 0
{ }
Depth: 1
Node{id='A', child=Node{id='B', child=Node{id='C', child=Node{id='D', child=null}}}} => 1
Node{id='B', child=Node{id='C', child=Node{id='D', child=null}}} => 0
{
  "id" : "A",
  "child" : { }
}
Depth: 2
Node{id='A', child=Node{id='B', child=Node{id='C', child=Node{id='D', child=null}}}} => 2
Node{id='B', child=Node{id='C', child=Node{id='D', child=null}}} => 1
Node{id='C', child=Node{id='D', child=null}} => 0
{
  "id" : "A",
  "child" : {
    "id" : "B",
    "child" : { }
  }
}
Depth: 3
Node{id='A', child=Node{id='B', child=Node{id='C', child=Node{id='D', child=null}}}} => 3
Node{id='B', child=Node{id='C', child=Node{id='D', child=null}}} => 2
Node{id='C', child=Node{id='D', child=null}} => 1
Node{id='D', child=null} => 0
{
  "id" : "A",
  "child" : {
    "id" : "B",
    "child" : {
      "id" : "C",
      "child" : { }
    }
  }
}