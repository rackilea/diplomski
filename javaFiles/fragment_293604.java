<select id="..." parameterType="..." statementType="CALLABLE">
    declare
          my_cursor SYS_REFCURSOR;
    begin
          OPEN my_cursor FOR
                    <foreach item="item" collection="..." separator=" union all ">
                    SELECT #{item.key} as key, ... FROM dual
                    </foreach> ;

        #{result,jdbcType=CURSOR,mode=OUT,resultMap=...,javaType=java.sql.ResultSet} := our_function(my_cursor => my_cursor);
    end;
</select>