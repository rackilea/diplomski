@RequestMapping(value="/employee/{id}", method= RequestMethod.GET)
// "id" maybe not necessary but definitely a good practice
public String deleteEmployee(@PathVariable("id") int id) {

    try {
        Connection connection = getConnection();
        Statement stmt = connection.createStatement();
        String sql;
        // not sure you need to put param in ' ' here
        // but you could try both varians and see if it makes any difference
        sql = "DELETE FROM salesforce.Employee__c WHERE Id = "+ id;
        System.out.println(sql);
        int result = stmt.executeUpdate(sql);
        System.out.println("execute update returned: " + result);
    }catch(Exception e){
        e.printStackTrace();
    }
    return "redirect:/employees";
}