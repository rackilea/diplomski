<insert id="insertServiceCode" useGeneratedKeys="true"
    keyColumn="code" keyProperty="code">
  insert into service_code (
    code,
    serv_info_seq_id,
    name,
    default_key_type,
    cre_date,
    creator,
    description,
    state
  ) values (
    service_code_seq.nextval,
    #{item.servInfoSeqId},
    #{item.name},
    #{item.defaultKeyType},
    systimestamp,
    #{item.creator},
    #{item.description},
    0
  )
</insert>