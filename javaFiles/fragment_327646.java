if (v == -1) {
    System.out.println("DEAD END HERE");
    theStack.pop();
    vertexList[last].label = "O";
    vertexList[last].wasVisited = false;
    adjMat[vertexList[last].lastVisited][last] = 0;
    vertexList[last].lastVisited = 0;
    displayBoard();
}