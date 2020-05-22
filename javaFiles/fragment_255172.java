<target name="CopyJre" depends="CreatingExe"> 
 <delete dir="${app_path}/bundles/MyApplication/runtime/jre"/>
 <mkdir dir="${app_path}/bundles/MyApplication/runtime/jre"/>
 <copy todir=${app_path}/bundles/MyApplication/runtime/jre">
   <fileset dir="${env.JAVA_HOME}/jre" />
 </copy>
</target>