CREATE OR REPLACE function MUNGAI.hash_password(par_username in varchar2,
                              par_password in varchar2,
                              par_work in varchar2
                             )
  return raw
is
  l_hash raw(2000);
begin
  l_hash :=
   dbms_crypto.hash
     (utl_i18n.string_to_raw (par_password || par_work || upper(par_username),
                              'AL32UTF8'
                             ),
      dbms_crypto.hash_sh1
     );
  return l_hash;
end;