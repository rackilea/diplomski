<insert id="batchAddIntegers" parameterType="java.util.List">
    DECLARE @ValuesToInsertTempTable TABLE (ColumnName integer)
    DECLARE @UpdateVariable integer

    SET NOCOUNT ON

    INSERT INTO @ValuesToInsertTempTable (ColumnName) VALUES
    <foreach item="item" index="index" collection="list" open="(" separator="),(" close=")">
        #{item}
    </foreach>

    SET NOCOUNT OFF

    MERGE TargetTable
    USING @ValuesToInsertTempTable AS S
    ON  TargetTable.ColumnName=S.ColumnName
    WHEN NOT MATCHED THEN
        INSERT (ColumnName) VALUES (S.ColumnName)
    WHEN MATCHED THEN
        UPDATE SET @UpdateVariable = @UpdateVariable + 1;
</insert>