String[] categories = MainActivity.categories.split(" ");
boolean found = false;
for (int i = (listaManga.getManga().size() - 1); i >= 0; i--) {
    found = false;
    for (int j = (categories.length - 1); j >= 0; j--) {
        for (int z = (listaManga.getManga().get(i).getC().size() - 1); z >= 0; z--) {
            if (!categories[j].contains(String.valueOf(listaManga.getManga().get(i).getC().get(z)))) {
                  listaManga.getManga().remove(i);
                  // Either do this
                  // i = i - 1;
                  // or put a flag here that is
                  // found == true;

                  break;
            }

            //if(found == true){
            //     break;
            //}
        }
    }
   }