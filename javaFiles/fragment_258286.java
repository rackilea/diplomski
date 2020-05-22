procedure add_image( id numeric(10), pic blob) 
  AS       
  BEGIN 
      insert into pictures 
          values (seq_pic.nextval, id, empty_blob()); 
      update pictures 
      set col_pic = pic
      where id = seq_pic.currval;
  END add_image;