-- disable constraints
BEGIN
    FOR c IN (
        SELECT c.owner, c.table_name, c.constraint_name, c.constraint_type
        FROM user_constraints c
        INNER JOIN user_tables t ON (t.table_name = c.table_name)
        AND c.status = 'ENABLED'
        AND c.constraint_type NOT IN ('C', 'P')
        ORDER BY c.constraint_type DESC
    )
    LOOP
        dbms_utility.exec_ddl_statement('alter table '||c.table_name||' disable constraint ' || c.constraint_name);
    END LOOP;
END;

-- do the updates
BEGIN
    FOR t IN (
        SELECT table_name, column_name
        FROM user_tab_columns
        WHERE column_name = 'TEMPERATURE'
        AND data_type = 'VARCHAR2';
    )
    LOOP
        dbms_utility.exec_ddl_statement('UPDATE '||t.table_name||' SET ' ||t.column_name||' = '||''GOOD VALUE''||' WHERE '||t.column_name||' = '||''BAD VALUE'');
    END LOOP;
END;

-- re-enable constraints
BEGIN
    FOR c IN (
        SELECT c.owner, c.table_name, c.constraint_name, c.constraint_type
        FROM user_constraints c
        INNER JOIN user_tables t ON (t.table_name = c.table_name)
        AND c.status = 'DISABLED'
        AND c.constraint_type NOT IN ('C', 'P')
        ORDER BY c.constraint_type ASC
    )
    LOOP
        dbms_utility.exec_ddl_statement('alter table '||c.table_name||' enable constraint ' || c.constraint_name);
    END LOOP;
END;
/