rule "testrule1"
when
  Test(name == "abc")
then
    System.out.println("Test rule is successfully executed");
end