<script>
SELECT * FROM STUDENT
WHERE DEPARTMENT_ID = #{depId}
<if test='joiningDate != null'> 
<![CDATA[
AND STUDENT_ID <= #{joiningDate} 
]]>
</if>
</script>