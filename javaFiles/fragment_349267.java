HandyMan handyMan = new HandyMan();
handyMan.setId() // Set the selected id.

Company company = new Company();
company.setId() // Set the selected company id.

workOrder.setCompany(company);
workOrder.setHandyMan(handyMan);

// Populate other details of work order and save using hibernate api.