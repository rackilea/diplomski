<update id="cancelPackage" statementType="CALLABLE">
    {call pa_packages.cancel_cellular_packages(
    #{PKT_ID, mode=IN, jdbcType=VARCHAR}
    , #{CAN_DATE, mode=IN, jdbcType=DATE, javaType=java.util.Date}
    , #{CELLULAR, mode=IN, jdbcType=VARCHAR}
    ...)}
</update>