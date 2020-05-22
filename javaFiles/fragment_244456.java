<target name="UserServiceTest">
        <mkdir dir="${junit.output.dir}" />
        <junit fork="yes" printsummary="withOutAndErr">
            <formatter type="xml" />
            <batchtest fork="yes" todir="${junit.output.dir}">
                 <fileset dir="${src.tests}">
                      <include name="webapp.service.*ServiceTest"/> 
                  </fileset>
            </batchtest>
            <jvmarg line="-ea" />
            <classpath refid="Web Application.classpath" />
        </junit>
</target>