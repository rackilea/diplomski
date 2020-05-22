<copy todir="${dest.dir}/src" verbose="true"  >
 <fileset dir="${RootFolder}">          
  <include name="**/JavaSource/com/**/*.java"/>
 </fileset>
 <cutdirsmapper dirs="1"/>
</copy>