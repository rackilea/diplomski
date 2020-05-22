public class DefaultTreeRenderer extends DefaultTreeCellRenderer {
private static final long serialVersionUID = 1L;
Map<String,Icon> amap = new HashMap<>();
ArrayList<String > drawList = new ArrayList<>();

public DefaultTreeRenderer(ArrayList<String > list,Map<String,Icon> amap1) throws IOException {

    setData(list,amap1);
}


private void setData(ArrayList<String > lists,Map<String,Icon> amap2){
    amap = amap2;
    drawList = lists;
}

@Override
public Component getTreeCellRendererComponent(
                    JTree tree,
                    Object value,
                    boolean sel,
                    boolean expanded,
                    boolean leaf,
                    int row,
                    boolean hasFocus) {



           super.getTreeCellRendererComponent(
                    tree, value, sel,
                    expanded, leaf, row,
                    hasFocus);


   Object nodeInfo = ((DefaultMutableTreeNode) value).getUserObject();
   Icon bn = this.leafIcon;

    if (getDrawable(nodeInfo)) {
      setIcon(amap.get(nodeInfo.toString()));     
  } 

   if(this.getIcon()!=null && leaf) {
       setText(nodeInfo.toString()+"       √");
   }
   if(this.getIcon()==null && leaf){
        setIcon(bn);
    }



    return this;
}

protected boolean getDrawable(Object value) {

    String title = value.toString();

    for(String c : drawList){
    if (title.equals(c)) {
        return true;
    }
    }

    return false;
   }
}