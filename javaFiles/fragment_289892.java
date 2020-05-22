public EmployeePresenter(EmployeeView view) {

    List<Employee> employees = ...; // get the list of employees
    Callback callback = new Callback(){
        void onClick(int position){
            listViewClick(position);
        }
    }
    view.initView(employees, callback);
}


public interface Callback{
    void onClick(int position);
}