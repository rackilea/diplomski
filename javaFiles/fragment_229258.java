<insert id="insertAccountabilityUsers" parameterType="AccountabilityUsersModel" useGeneratedKeys="false">
    INSERT INTO accountability_users 
        (
            accountability_user_id, accountability_id, to_username,
            record_status, created_by, created_at, updated_by, updated_at
        ) 
    VALUES
    <foreach collection="usersList" item="model" separator=","> 
        (           
            #{model.accountabilityUserId}, #{model.accountabilityId}, #{model.toUsername}, 
            'A', #{model.createdBy}, #{model.createdAt}, #{model.updatedBy}, #{model.updatedAt}     
        )
    </foreach>
</insert>