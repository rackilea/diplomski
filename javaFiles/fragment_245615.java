start n=node(*) 
match p=n-[:OWES*1..200]->(m), (m)-[r:OWES]->n 
where HAS(n.taxnumber) 

AND NOT(n IN tail(nodes(p)))

return  extract(s in relationships(p) : s.amount) + r.amount, 
        extract(t in nodes(p) : ID(t)) + ID(n), 
        length(p) + 1;