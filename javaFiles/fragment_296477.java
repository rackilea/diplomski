private boolean input;
private List<String> chcekItem= new ArrayList<String>();

public void setAction(String action) {
input=true; 
if (getChcekItem().isEmpty()) {
        getChcekItem().add(action);
    } else {
        //Foreach loop instead of an iterator ;)
        for(String item : chcekItem) {
            if(item.equals(action)) {
                System.out.println(item+"="+action);
                input=false;
                //We can jump out of the loop here since we already found a matching value
                break;
            }
        }         
        if (input) {
            getChcekItem().add(action);
            System.out.println("The item " + action + " is Successfully Added to               array");
        }else{
            System.out.println("The item " + action + " is Exist");
        }
      }
    }
}