insert overwrite target_data [partition() if applicable]
SELECT
  --select new if exists, old if not exists
  case when i.PK is not null then i.PK   else t.PK   end as PK,
  case when i.PK is not null then i.COL1 else t.COL1 end as COL1,
  ... 
  case when i.PK is not null then i.COL_n else t.COL_n end as COL_n
  FROM 
      target_data t --restrict partitions if applicable
      FULL JOIN increment_data i on (t.PK=i.PK);