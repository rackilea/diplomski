select *
  from t
  order by n;

select n, rownum
  from t
  where rownum < 100
  order by n;

select n, rownum as r from
 (select n
    from t
    order by n);

select n, r from
 (select n, rownum as r from
   (select n
      from t
      order by n))
  where r < 100
  order by n;