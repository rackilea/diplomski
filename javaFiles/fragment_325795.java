merge into you_target_table tt
using ( select value1
               , count(*) as dup_cnt
        from your_source_table
        group by value1
      ) st
on ( st.value1 = tt.value1 )
when not matched then
   insert (id, value1, cnt) 
   values (someseq.nextval, st.value1, st.dup_cnt)
when matched then
   update
   set tt.cnt = tt.cnt + st.dup_cnt;