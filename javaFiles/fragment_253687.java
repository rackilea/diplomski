<target name="fixmeCheck">
  <fail message="Fixmes found">
    <condition>
      <not>
        <resourcecount count="0">
          <fileset dir="${pom.build.sourceDirectory}"
                   includes="**/*.java">
             <contains text="FIXME" casesensitive="yes"/>
          </fileset>
        </resourcecount>
      </not>
    </condition>
  </fail>
</target>

<target name="compile" depends="fixmeCheck">