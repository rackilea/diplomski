<mapper namespace="com.example.PersonRepository">
    <!-- The common re-usable SELECT query -->
    <sql id="select-part">
        SELECT first_name, last_name, ...other attributes... 
        FROM table
        <!-- You may use dynamic parameters here the same way as in a regular query -->
        <where>
            <if test="searchParams.firstName != null">
                first_name = #{searchParams.firstName}
            </if>
            <if test="searchParams.lastName != null">
                and last_name = #{searchParams.lastName}
            </if>
        </where>
    </sql>

    <!-- Method List<Type1> getAsType1(SearchParams searchParams) -->
    <select id="getAsType1" resultMap="map1">
        <include refid="select-part"/>
    </select>

    <!-- Method List<Type2> getAsType2(SearchParams searchParams) -->
    <select id="getAsType2" resultMap="map2">
        <include refid="select-part"/>
    </select>

    <resultMap id="map1" type="Type1">
        ...
    </resultMap>

    <resultMap id="map2" type="Type2">
        ...
    </resultMap>
</mapper>