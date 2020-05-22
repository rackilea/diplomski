SELECT 
*
FROM
    Val;

select 
    t0.valId c0, 
    t0.graphId c1, 
    t0.Key c2, 
    t0.Value c3, 
    t0.graphId c4 <---- notice this duplicate
from 
    graph_val t0