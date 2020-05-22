public void getStringFreq (Node node, Map<String, Integer> map)
{
    if (node == null) {
       return;
    }

   /* left child */
   getStringFreq(node.left, map);

   /* get the data of node */
   String s = node.data;

   Integer i = map.get(s); // have we mapped it yet

   // not yet
   if (i == null)
      map.put(s, 1);
   // already mapped, increment freq
   else
      map.put(s, i + 1);

   /* right child */
   getStringFreq(node.right, map);
}