ArrayList<Double> total = new ArrayList<Double>();
int existAtIndex;
    for(int i = 0; i < categorylist.size(); i++){
        // search for the element index
        existAtIndex = -1;
        for(int j = 0; j < currentMonthByCat.size(); j++){
            if(categorylist.get(i).getCategoryID().equals(currentMonthByCat.get(j).getCategory().getCategoryID())){

                existAtIndex = j;
                break;
            }
        }

        // add the value in the element index or add zero if the element not exist
        if (existAtIndex != -1) {
          total.add((double)currentMonthByCat.get(existAtIndex).getTransactionAmt());
        }
        else {
            total.add(0.0);
        }
    }

    for(int k = 0; k < total.size(); k++){
        Log.d(String.valueOf(total.get(k)));
    }