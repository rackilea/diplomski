<select id="getSearchResultByParams" parameterType="map" resultMap="SearchResultMap">
    SELECT *
    FROM WORK
    WHERE ID IN 
         <foreach collection="selectedGroups" item="item" index="index" open="(" separator="," close=")">
            #{item}
        </foreach>
</select>