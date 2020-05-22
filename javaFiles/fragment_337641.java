<rich:treeNode type="FIELD" iconCollapsed="/images/field_icon.gif" iconExpanded="/images/field_icon.gif"
    iconLeaf="/images/field_icon.gif">
    <h:outputText value="#{node.nodeName}" />
    <rich:dragSource dragValue="#{node}" type="FIELD" dragIndicator="fieldIndicator" />
    <rich:dragIndicator id="fieldIndicator">
        <h:outputText value="#{node.nodeName}" />
    </rich:dragIndicator>
</rich:treeNode>