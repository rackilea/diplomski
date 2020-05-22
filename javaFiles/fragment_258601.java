t=# explain (analyze, format xml) select * from pg_database join pg_class on true;
                           QUERY PLAN
----------------------------------------------------------------
 <explain xmlns="http://www.postgresql.org/2009/explain">      +
   <Query>                                                     +
     <Plan>                                                    +
       <Node-Type>Nested Loop</Node-Type>                      +
       <Join-Type>Inner</Join-Type>                            +
       <Startup-Cost>0.00</Startup-Cost>                       +
       <Total-Cost>23.66</Total-Cost>                          +
       <Plan-Rows>722</Plan-Rows>                              +
       <Plan-Width>457</Plan-Width>                            +
       <Actual-Startup-Time>0.026</Actual-Startup-Time>        +
       <Actual-Total-Time>3.275</Actual-Total-Time>            +
       <Actual-Rows>5236</Actual-Rows>                         +
       <Actual-Loops>1</Actual-Loops>                          +
       <Plans>                                                 +
         <Plan>                                                +
           <Node-Type>Seq Scan</Node-Type>                     +
           <Parent-Relationship>Outer</Parent-Relationship>    +
     ...and so on