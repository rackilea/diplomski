List<Line> lineList = new ArrayList<>();
for (Node currentNode : anchorPaneGame.getChildren()){
    if (currentNode instanceof Line){
        lineList.add((Line)currentNode);
    }
}