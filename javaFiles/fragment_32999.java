for (int i = 0; i < vecForShapes.size(); i++) {
     currentNode = (Drawable) shape;
     newNode = getResources().getDrawable(R.drawable.nodered);
     newNode.setBounds(currentNode.getBounds());
     vecForSahpes.set(i, newNode);
}