<ui:repeat var="blockName" value="#{page1Bean.blockNames}" varStatus="status">
            <ui:fragment rendered="#{blockName == 'block1'}">
                <ui:include src="#{page1Bean.theBlockName}" >
                    <ui:param name="bean" value="#{page1Bean.myBean}"/>
                </ui:include>
            </ui:fragment>

            <ui:fragment rendered="#{blockName != 'block1' }">
                <ui:include src="block2.xhtml" />
            </ui:fragment>

        </ui:repeat>