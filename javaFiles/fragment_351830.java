SQL> create or replace procedure p_mac
  2    (par_state in number, par_rpd in varchar2, par_mac_address in varchar2)
  3  is
  4    l_row mac%rowtype;
  5  begin
  6    select *
  7      into l_row
  8      from mac
  9      where mac_address = par_mac_address;
 10
 11    update mac set
 12      total_count = total_count - 1
 13      where mac_address = par_mac_address;
 14
 15    insert into mac (state, rpd, mac_address, total_count)
 16    values
 17    (par_state, par_rpd, par_mac_address, 1);
 18  exception
 19    when no_data_found then null;
 20  end;
 21  /

Procedure created.