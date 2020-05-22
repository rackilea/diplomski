Query:{[insert into a_class (auid, firstId_huid) values (default, ?)][-5]} 
Query:{[insert into h_class (huid, somefield) values (default, ?)][some value goes here]} 
Query:{[insert into h_class (huid, somefield) values (default, ?)][another value goes here]} 
Query:{[insert into a_class_h_class (a_class_auid, secondIds_huid) values (?, ?)][1,1]} 
WARN  [Alice]: o.h.e.j.s.SqlExceptionHelper - SQL Error: -10, SQLState: 23502
ERROR [Alice]: o.h.e.j.s.SqlExceptionHelper - integrity constraint violation: NOT NULL check constraint; SYS_CT_10096 table: A_CLASS_H_CLASS column: THIRDIDS_HUID