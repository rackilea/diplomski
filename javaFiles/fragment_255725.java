<select id="selectCOLC" parameterType="map" resultType="kpMap">
    SELECT COL_C
    FROM TBLE_1
    WHERE (COL_A, COL_B) in 
    <foreach item="item" collection="entries.entrySet()" open="((" separator="),(" close="))">
        #{item.key},#{item.value}
    </foreach>
</select>