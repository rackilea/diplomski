<target name="addwsdlnametocomment">
    <replaceregexp match="(WSDL2Java emitter)\.(.*\*/)" flags="sm"  //or only s or only m???
        replace="\1 (${src.dir.etc}/wsdl/BLAH.wsdl)\2">
        <fileset dir="${build.dir.generated_src}">
            <include name="**/*.java"/>
        </fileset>
    </replaceregexp>
</target>