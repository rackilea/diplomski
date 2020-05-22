<ejbgen source="1.6" outputDir="${staging.dir}" descriptorDir="ejbModule\META-INF" forceGeneration="true" 
verbose="true"
            ejbSuffix = "."
            localSuffix = "Local"
            localHomeSuffix = "LocalHome">
            <fileset dir="ejbModule/sample/oss/dna/ejb">
                    <contains text="@Session"/>
                    <contains text="@LocalMethod"/>
            </fileset>
</ejbgen>