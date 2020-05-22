for each neighborNode
 for(int i = 0; i < topNList.size(); i++){
       if((dist = distanceMetric(neighborNode,currentNode)) > topNList.get(i).distance){
             topNList.remove(topNList.size()-1)
             neighborNode.setDistance(dist);
             topNList.add(i, neighborNode);
       }