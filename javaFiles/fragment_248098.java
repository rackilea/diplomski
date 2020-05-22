f := utl_file.fopen('my_dir','my_file','w');
FOR r_items IN (SELECT * FROM items) LOOP
  utl_file.put_line(f,r_items.name);

  FOR r_audit IN (SELECT * FROM audit WHERE item_id = r_items.id) LOOP
    utl_file.put_line(f,r_audit.some_field);
  END LOOP;

  FOR r_comments IN (SELECT * FROM comments WHERE item_id = r_items.id) LOOP
    utl_file.put_line(f,r_comments.some_field);
  END LOOP;
END LOOP;