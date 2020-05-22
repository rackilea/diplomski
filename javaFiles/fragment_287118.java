<javac verbose="on"
    srcdir="${src.dir}"
    destdir="${build.dir}/${context.path}/classes"
    debug="${compile.debug}"
    debuglevel="${javac.debuglevel}"
    optimize="${compile.optimize}"
    deprecation="${javac.deprecation}"
    source="1.6"
    target="1.6"
    failonerror="true">
    <compilerarg line=" -processor org.datanucleus.enhancer.EnhancerProcessor" />
    <compilerarg line=" -proc:only" compiler="javac1.6" />
    <classpath refid="compile.classpath"/>
</javac>