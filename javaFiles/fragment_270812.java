<zk>
  <style>
    .z-treecell:first-child .z-treecell-content {
      display: flex;
    }
    .z-treecell:first-child .z-tree-icon {
      order: 1; /*order it to the right*/
    }
    .z-treecell:first-child .z-tree-icon+.z-treecell-text {
      margin-left: 24px; /*this value might need adjustment based on the theme*/
    }
  </style>
  <tree>
    <treechildren>
      <treeitem label="item 1"/>
      <treeitem label="item 2">
        <treechildren>
          <treeitem label="item 2.1">
            <treechildren>
              <treeitem label="item 2.1.1"/>
            </treechildren>
          </treeitem>
        </treechildren>
      </treeitem>
    </treechildren>
  </tree>
</zk>