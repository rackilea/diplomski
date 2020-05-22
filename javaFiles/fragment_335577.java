Element eElement = (Element) nNode;
String firstName = eElement.getElementsByTagName("firstname").item(0).getTextContent();
// You might want to catch NumberFormatException here if input is not a valid integer
int salary = Integer.parseInt(eElement.getElementsByTagName("salary").item(0).getTextContent());

if (firstName.length() > 4) {
  System.err.println("Validation failed-count is more than 4");
} else if (salary != 100000) {
  System.err.println("Validation failed-salary is not 100000");
} else {
  System.out.println("Staff id :" + eElement.getAttribute("id"));             
  System.out.println("First Name :" + firstName);
  System.out.println("Last Name :" + eElement.getElementsByTagName("lastname").item(0).getTextContent());
  System.out.println("Nick Name :" + eElement.getElementsByTagName("nickname").item(0).getTextContent());
  System.out.println("Salary : " + salary);             
}