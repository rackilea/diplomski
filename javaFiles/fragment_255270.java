// add a function for finding cost per item like this

public HashMap<String,Double>  getCostPerItem(int i) {
           HashMap<String, Double> itemPriceName= new HashMap<String, Double>();
           itemPriceName.put(list.get(i).getName(), 
              (list.get(i).getPricePerUnit()*list.get(i).getQuantity()));
          return itemPriceName;
       }