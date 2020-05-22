<unzip dest="${release.dir}/image/tomcat" src="${tomcat.zip}">
    <patternset>
        <include name="apache-tomcat-6.0.29/*"/>
    </patternset>
    <mapper>
        <globmapper from="apache-tomcat-6.0.29/*" to="*"/>
    </mapper>
</unzip>