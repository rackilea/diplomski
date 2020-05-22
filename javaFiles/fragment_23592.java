Animal animal= null;
switch (animalChosen) {
    case "Chien":
        animal = new Chien(animalName);
        break;
    case "Chat":
        animal = new Chat(animalName);
        break;
    case "Furet":
        animal = new Furet(animalName);
        break;
      default
        break;
 }
 animal.displayStat();