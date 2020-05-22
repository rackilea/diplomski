merge into td
  using ( select   c1, c2, max(c3) as max_c3
          from     td
          group by c1, c2
        ) x
        on (td.c1 = x.c1 and td.c2 = x.c2 and td.c3 = max_c3)
when matched then update
  set c5 = 1
;