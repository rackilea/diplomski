select *
from named <name-of-graph>
{
  ?s ?p ?o
}

select * {
  graph <name-of-graph> {  
    ?s ?p ?o
  }
}