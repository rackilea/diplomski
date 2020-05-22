<workflow>  
    <property name="project.src.directory" value="${projectBasedir}/src/main"/>
    <property name="project.target.directory" value="${projectBasedir}/target"/>

    <property name="modelFileDir" value="${project.src.directory}/xtext/model/"/>   
    <property name="srcGenTargetDir" value="${project.target.directory}/generated-sources"/>    
    <property name="templateTargetDir" value="${project.target.directory}/generated-sources-templates"/>

    <bean class="org.eclipse.emf.mwe.utils.StandaloneSetup" platformUri=".."/>

    <component class="org.eclipse.emf.mwe.utils.DirectoryCleaner" directory="${srcGenTargetDir}"/>
    <component class="org.eclipse.emf.mwe.utils.DirectoryCleaner" directory="${templateTargetDir}"/>
    <component class="org.eclipse.xtext.mwe.Reader" path="${modelFileDir}" >
        <register class="com.queomedia.bcsweb.productdefinition.ProdDef2StandaloneSetup"/>
        <load slot='model' type='Model'/>
    </component>

    <component class="org.eclipse.xpand2.Generator">
        <metaModel class="org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel"/>
        <fileEncoding value="UTF-8"/>
        <expand value="templates::ProductCustomClass::productCustomClasses FOREACH model"/>
        <genPath value="${templateTargetDir}"/>

        <beautifier class="org.eclipse.xpand2.output.JavaBeautifier"/>  
    </component>

    <component class="org.eclipse.xpand2.Generator">
        <metaModel class="org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel"/>
        <fileEncoding value="UTF-8"/>       
        <expand value="templates::Main::main FOREACH model"/>
        <genPath value="${srcGenTargetDir}"/>

        <beautifier class="org.eclipse.xpand2.output.JavaBeautifier"/>
    </component>

</workflow>