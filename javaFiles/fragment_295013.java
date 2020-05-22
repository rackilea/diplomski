@ManagedBean
@ViewScoped
public class bean{
    private List<SelectItem> productList = null;
    private List<SelectItem> departmentList = null;
    private Long selectedProduct = null;
    private Long selectedDepartment = null;

    @PostConstruct
    public void init(){
        //Pre load product list
        productList = new ArrayList<SelectItem>();
        productList.add(new SelectItem("value1", "label1"));  
        productList.add(new SelectItem("value2", "label2"));  
        productList.add(new SelectItem("value3", "label3"));  
        //The values are the keys passed to the selectItem property.  
        //The labels are those what you see on the menu.  
    }

    public void loadDepartmentById(){
        if(selectedProduct != null){
            //Load the appropriate list of department.
        }
    }

}