<if>
   <or>
    <equals arg1="${var}" arg2="one"/>
    <equals arg1="${var}" arg2="two"/>
    <equals arg1="${var}" arg2="three"/>
    <equals arg1="${var}" arg2="four"/>
   </or>
   <then>
    <echo message="basic dir: ${var}"/>
    <copy todir="../direct" verbose="yes" failonerror="no" overwrite="yes">
        <fileset dir="${var}">
            <include name="**"/>
        </fileset>
    </copy>
   </then>
</if>