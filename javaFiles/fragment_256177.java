@Controller
@SubdomainMapping(value = "subdomain", tld = ".mydomain.com")
class MyController1 {
    // Code here will be executed only on address match:
    // subdomain.mydomain.com
}