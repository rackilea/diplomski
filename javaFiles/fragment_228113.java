public IWizardPage getNextPage(){
   saveDataToModel();       
   if (planeButton.getSelection()) {
       PlanePage page = ((HolidayWizard)getWizard()).planePage;
     page.onEnterPage();
       return page;
   }
   // Returns the next page depending on the selected button
   if (carButton.getSelection()) { 
    return ((HolidayWizard)getWizard()).carPage;
   }
   return null;
}