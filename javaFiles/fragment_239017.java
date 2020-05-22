<target name="update" depends="download" description="moves downloded dat files to projects dest">
    <for param="file" delimiter=";">
        <path>
            <fileset dir="${downloads}" includes="*.dat" casesensitive="false" />
        </path>
        <sequential>
            <echo>file: @{file}</echo>
            <basename file="@{file}" property="filename" />
            <!--echo>filename: ${filename}</echo-->
            <propertyregex property="uniq" input="${filename}" regexp="^[^.]*(?=_)" select="\0" casesensitive="false" />
            <echo>uniq: ${uniq}</echo>
            <delete dir="${dest}" includes="${uniq}*" />
            <copy file="@{file}" tofile="${dest}/${filename}" />
            <var name="uniq" unset="true" />
            <var name="filename" unset="true" />
        </sequential>
    </for>
</target>