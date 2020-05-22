create.begin(
  declare(clobDaten),
  clobdata.set(select(t.CLOB_FIELD).from(t).where(t.ID.eq(id)).forUpdate()),
  statement("dbms_lob.append(dest_lob => {0}, src_lob => 'append_this')", clobdata),
  update(t).set(t.CLOB_FIELD, clobdata).where(t.ID.eq(id))
).execute();