<select id="selectXXXList" parameterType="beanA" resultType="hashmap">    
    select * from TABL where 
    <foreach  collection="map"  index="key" item="value"  open=""  separator=" and "  close="">
        ${key}=#{value}
    </foreach>
</select>