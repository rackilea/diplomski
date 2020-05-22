public class CompaniesPresenter {
    private List<CompanyMaster> companyMaster;
    private string status;

//default constructor
public CompaniesPresenter(){

    }

//parameterized constructor to return only string in exception case

public CompaniesPresenter(Stirng status){
        this.status = status;
    }

//parametirized constructor to return success case
public CompaniesPresenter(List<CompanyMaster> companyMaster, Stirng status){
        this.companyMaster = companyMaster;
        this.status = status;
    }

    //getters and setters
    }