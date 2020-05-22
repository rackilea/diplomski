<javac encoding="${java.encoding}"
               source="${java.source}" target="${java.target}"
               debug="true" extdirs="" includeantruntime="false"
               destdir="${out.classes.absolute.dir}"
               bootclasspathref="project.target.class.path"
               verbose="${verbose}"
               classpathref="project.javac.classpath"
               fork="${need.javac.fork}">
            <src path="${source.absolute.dir}" />
            <exclude name="bbct/swing/**" />
            <src path="${gen.absolute.dir}" />
            <compilerarg line="${java.compilerargs}" />
        </javac>