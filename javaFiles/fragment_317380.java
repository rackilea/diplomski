<select id="getNameAgeDetails" parameterType="map" resultMap="someResultMap">
        SELECT P.NAME, P.AGE
        FROM PERSON_DETAILS P
        WHERE
         SOMECOLUMN is NULL
        AND DATA IN
          (SELECT DATA
          FROM PARENT_TABLE
          WHERE PARENT_VALUE IN 
         <FOREACH item="item"  index="index" collection="list" separator="," open="(" close=")"> 
                ${item}
            </FOREACH>  
          )
          ORDER BY P.NAME
          FETCH 
            FIRST 10 ROW ONLY 
  </select>