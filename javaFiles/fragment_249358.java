Then Use the following values
| <validation field1> | <validation field2> | <validation field3> |

Examples:
| input_1        |  validation field1 |validation field2|validation field3 |
| input_1_case_1 |  expected value 1  |expected value 2 |expected value 3  |
| input_2_case_2 |  expected value 1  |expected value 2 |expected value 3  |

Step Definition
@Then("^Use the following values$")
public void useFollVal(List<String> valFields) {
     //The values will be inside the list. Use index to access

}