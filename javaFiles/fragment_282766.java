<insert id="insert" parameterType="workday" useGeneratedKeys="true" keyProperty="idWorkDay">
      INSERT INTO workday 
        ( start , end , workweekID , DAY_TYPE )
      VALUES (
        #{start},
        #{end},
        #{workweekID},
        #{DAY_TYPE, typeHandler=org.apache.ibatis.type.EnumTypeHandler}
      )
        <selectKey keyProperty="idWorkDay" resultType="long" order="AFTER">
            SELECT LAST_INSERT_ID();
        </selectKey>
    </insert>