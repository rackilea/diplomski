private NodeTree find(NodeTree q, String cont){
   if(q==NULL) return NULL;
   if(q._contingut.equals(cont)) return q;

   NodeTree result = NULL;
   if(!q._left) result = find(q._left,cont);
   if(!result && q._right) result = find(q._right,cont);
   return result;
}