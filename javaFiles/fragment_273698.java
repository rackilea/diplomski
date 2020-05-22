<o:tree value="#{bean.treeModel}" var="item" varNode="node">
    <o:treeNode>
        <ul>
            <o:treeNodeItem>
                <li>
                    #{node.index} #{item.someProperty}
                    <o:treeInsertChildren />
                </li>
            </o:treeNodeItem>
        </ul>
    </o:treeNode>
</o:tree>