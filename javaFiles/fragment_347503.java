Tree animal = new Tree();
animal.instruction();
animal.play();
animal.writeToFile("treeData.ser");
Tree newAnimal = Tree.readFromFile("treeData.ser");
///should the following not be newAnimal?
animal.play();