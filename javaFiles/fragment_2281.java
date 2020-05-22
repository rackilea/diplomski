// test data
List<String> countries = Arrays.asList("UK", "FR","CA", "US");
List<String> numbers = Arrays.asList("123", "789");

// these can be compile-time constants
String disjunct  = " or ";
String conjunct = " and ";
String countryFormat = "country='%s'";
String numberFormat = "number='%s'";

// result 
StringBuilder result = new StringBuilder("&filter=");

// adding countries
for (String country: countries) {
    result.append(String.format(countryFormat, country)).append(disjunct);
}
// removing last "or"
result.delete(result.lastIndexOf(disjunct), result.length());

// adding first "and"
result.append(conjunct);

// adding numbers
for (String number: numbers) {
    result.append(String.format(numberFormat, number)).append(conjunct);
}
// removing last "and"
result.delete(result.lastIndexOf(conjunct), result.length());

// printing result
System.out.println(result);