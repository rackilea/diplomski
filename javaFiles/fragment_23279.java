<target name="compile">
    <javac srcdir="${src}"
        destdir="${target}"
        classpath="${classpath}"
        source="${src.jdk}"
        target="${target.jdk}"
        debug="on"
        debugLevel="lines,vars,source" />
</target>