<select id="get_party_details" parameterType="StudentVO" 
            statementType="PREPARED" resultMap="partyMap">
                select * from get_party_details
                <foreach item="item" index="index" collection="studentFriendNums"
                    open="(" separator="," close=")">
                #{item}
               </foreach>
    </select>