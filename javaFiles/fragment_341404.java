case 0:
    int index = Integer.parseInt(stat);
    SearchableByIndex foundItem = SorcerersCave.theCave.searchByIndex(index);
    if (foundItem != null) {
        generateInterface.theGame.printOutput("\t" + foundItem);
    } else {
        // print out that the item was not found
    }
    break;