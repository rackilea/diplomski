import com.google.gson.Gson;

public class SOMain {
    public static void main(String[] args) throws Exception{

        Gson gson = new Gson();
        String json = "{\"First Name\":\"John\",\"Last Name\":\"Smith\"}";

        Employee employee = gson.fromJson(json, Employee.class);

        System.out.println(employee);

    }

}


import com.google.gson.annotations.SerializedName;
public class Employee {

    @SerializedName("Last Name")
    public String lastName;
    @SerializedName("First Name")
    public String firstName;

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Employee with first name " + firstName + " and last name " + lastName ;
    }

}