if (node.x < xMax) {
    if (node.nodes[2] == null) {
        node.nodes[2] = new Node3D();
    }
    Node3D newNode = node.nodes[2];
    newNode.x = node.x + 1;
    newNode.y = node.y;
    newNode.z = node.z;

    pnc(newNode, xMax, yMax, zMax);
}
if (node.y < yMax) {
    if (node.nodes[0] == null) {
        node.nodes[0] = new Node3D();
    }
    Node3D newNode = node.nodes[0];
    newNode.x = node.x;
    newNode.y = node.y + 1;
    newNode.z = node.z;

    pnc(newNode, xMax, yMax, zMax);
}
if (node.z < zMax) {
    if (node.nodes[4] == null) {
        node.nodes[4] = new Node3D();
    }
    Node3D newNode = node.nodes[4];
    newNode.x = node.x;
    newNode.y = node.y;
    newNode.z = node.z + 1;

    pnc(newNode, xMax, yMax, zMax);
}