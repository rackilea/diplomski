localhost.Database db = new WindowsFormsApplication1.localhost.Database();
// Assign the CookieContainer to the proxy class.  
db.CookieContainer = new System.Net.CookieContainer();

db.login();

localhost.getProjectResponse pr = new WindowsFormsApplication1.localhost.getProjectResponse();
pr.CookieContainer = db.CookieContainer;

pr = db.getProject();