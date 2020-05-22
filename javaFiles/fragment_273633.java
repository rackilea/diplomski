UPDATE table_name
  SET column_name_with_cs_values = 
        CASE WHEN FIND_IN_SET( value_to_find, 
                               column_name_with_cs_values 
                  ) > 0 THEN column_name_with_cs_values 
             ELSE CONCAT( column_name_with_cs_values, ',', value_to_find )
        END
-- add where etc here
;