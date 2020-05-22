Then Use the following values
| valField1 | valField2 | valField3 |   <<<--- Header to add 
| <validation field1> | <validation field2> | <validation field3> |     

        valField1 -> private String valField1; in ValidationData

    Step Definition
        @Then("^Use the following values$")
        public void useFollVal(List<ValidationData> valObject) {

        }