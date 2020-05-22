CREATE OR REPLACE procedure MUNGAI.p_auth_insert_user (par_username in varchar2,
                              par_password in varchar2,
                              par_work in varchar2
                             )
is
  l_hash raw(2000);
begin
  l_hash := hash_password( par_username, par_password, par_work );

  insert into user_login_table
    (user_name, p_word, work_class)
   values
    (par_username, l_hash, par_work);
end p_auth_insert_user;
/