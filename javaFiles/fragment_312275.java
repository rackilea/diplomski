interface IJiraClientProvider { 
    JiraRestClient getJiraRestClient();
 }

 class Wrapper implements IJiraClientProvider  { 
    JiraRestClient getJiraRestClient()  {
         return JiraRestClientProvider.getJiraRestClient();
     }
 } 

 class YourClass {  
 private IJiraClientProvider jiraClientProvider
 public YourClass(IJiraClientProvider jiraClientProvider)  {
     this.jiraClientProvider = jiraClientProvider; 
 }

 // now you can unit test your code and mock the dependency  
}