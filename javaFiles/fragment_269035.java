When searching by Login Name '<loginName>' as a filter
Then users only with '<loginName>' are displayed

Examples:
|loginName|
|admin|
|admin2|
|admin3|

  @When("searching by Login Name '<loginName>' as a filter")
   public void searchingBySpecifiedLoginNameAsAFilter(String loginName)
{
    ...

}