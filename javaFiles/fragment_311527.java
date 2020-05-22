select *
 from
  ( select rownum rnm, a.*
     from (your_query) a
     where rownum <= :M )
 where rnm >= :N;