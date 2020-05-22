drop procedure IF EXISTS migrate_custom_fields;

CREATE PROCEDURE migrate_custom_fields()
BEGIN
    IF ((SELECT count(1)
         FROM INFORMATION_SCHEMA.COLUMNS
         WHERE table_name = 'custom_field_instance_data'
           and column_name='entity_id' and is_nullable = false) > 0)
    THEN
        alter table custom_field_instance_data MODIFY COLUMN entity_id char(32) null;
    END IF;
END ;

call migrate_custom_fields;

drop procedure migrate_custom_fields;