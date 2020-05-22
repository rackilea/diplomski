public class Help {

public static void main(String args[]) {
    String str = "[{" + 
            "   \"name\": \"3214657890RootSAPSSE\"," + 
            "   \"children\": [{" + 
            "       \"name\": \"672BENIAMEEN .Sales Base Market SectionCustomer Representative\"," + 
            "       \"children\": [{" + 
            "           \"name\": \"672BENIAMEEN .Sales Base Market SectionPeão\"," + 
            "           \"children\": [{" + 
            "               \"name\": \"910MAZHAR .Sales Base Market SectionCustomer Representative\"," + 
            "               \"children\": [{" + 
            "                   \"name\": \"910MAZHAR .Sales Base Market SectionPeão\"," + 
            "                   \"children\": [{" + 
            "                       \"name\": \"713NOSHERWAN .Sales Sargodha SectionCustomer Representative\"," + 
            "                       \"children\": [{" + 
            "                           \"name\": \"713NOSHERWAN .Sales Sargodha SectionPeão\"" + 
            "                       }," + 
            "                       {" + 
            "                           \"name\": \"1161SAQLAIN .Sales Toba Taik Singh SecPeão\"" + 
            "                       }]" + 
            "                   }]" + 
            "               }]" + 
            "           }]" + 
            "       }," + 
            "       {" + 
            "           \"name\": \"1161SAQLAIN .Sales Toba Taik Singh SecCustomer Representative\"," + 
            "           \"children\": [{" + 
            "               \"name\": \"1179SHAMOON .Administration SectionDriver ( R )\"" + 
            "           }]" + 
            "       }]" + 
            "   }," + 
            "   {" + 
            "       \"name\": \"1179SHAMOON .Farooq Khan TrustDriver ( D)\"" + 
            "   }]" + 
            "}]";

    System.out.println(str);

    Gson gson = new Gson(); 
    Type type = new TypeToken<List<Employees>>(){}.getType();
    List<Employees >l = gson.fromJson(str, type);
    System.out.println(l);

    iterateOverEmployee(l); 
}

private static void iterateOverEmployee(List<EmployeeJSONObj> l) {
    for(EmployeeJSONObj emp: l){

        if(emp.getChildren() != null){

            for(int i=0;i<emp.getChildren().size();i++)
            {
                System.out.println("Name: "+emp.getChildren().get(i).getName()+"<br/>");
            }

            iterateOverEmployee(emp.getChildren());
        }           
    }
}