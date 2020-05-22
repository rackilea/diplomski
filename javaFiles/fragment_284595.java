public List<List<Integer>> getPermutations(ListNode currentNode) {  
       if(currentNode == null) {  
             return new ArrayList<ListNode>();  
       }   
       List<List<Integer>> nextPermutations = getPermutations(currentNode.next);  
       addToPermutations(currentNode, nextPermutations);  
       return nextPermutations;  
}  

public void addToPermutations(ListNode node, List<List<Integer>> permutations) {  
   for(List<Integer> permutation:permutations) {  
      addEachPosition(permutation, node.value);        
   }  
}