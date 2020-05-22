<configuration>

    <if condition='"${spring.profiles.active}".contains("profile1")'>
        <then>
         <!-- do whatever you want for profile1 -->
        </then>
    </if>

    <if condition='"${spring.profiles.active}".contains("profile2")'>
        <then>
         <!-- do whatever you want for profile2 -->
        </then>
    </if>

    <!-- common config -->

</configuration>