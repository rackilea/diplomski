import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
//...
//...

public void addCups() {
    //get string passed from xhtml page
    String values = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("coffeCups");
    //parse JSON string to List
    List<CoffeeQuantity> coffeCups = (ArrayList<CoffeeQuantity>) new Gson().fromJson(values, new TypeToken<ArrayList<CoffeeQuantity>>() {}.getType());
    for (CoffeeQuantity cq : coffeCups) {
        System.out.println("Coffee id: " + cq.getId() + ", Quantity:" + cq.getQuantity());
        if (cq.getQuantity()>0){
            selectedItems.put(cq.getId(), cq.getQuantity());
        }else{
            selectedItems.remove(cq.getId());
        }
    }
}