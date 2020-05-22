for (int i = 0; i < cell1.getEdgeCount(); i++) {
   mxCell source = ((mxCell) cell1.getEdgeAt(i)).getSource();
   mxCell target = ((mxCell) cell1.getEdgeAt(i)).getTarget();
   if (source == cell2 || target == cell2)
       return true;
   else
       return false;
}