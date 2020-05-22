public Object searchForStudentAccomodation(String studentNo){
        String invoiceHeader = getTextFromElement(INVOICE_HEADER_IDENTIFIER);
        switch (invoiceHeader){
            case "Create Accommodation Credit Note : Select Student" :
                commonInvoiceAction(studentNo);
                return new CreditNoteSelectInvoicePage(driver); 

            case "Create Accommodation Invoice : Select Invoice" :
                commonInvoiceAction(studentNo);
                return new AccomodationInvoiceDetails(driver);

            default :
                System.out.println("Invalid invoice header : "+invoiceHeader);
                return  null;

        }
    }

    public void commonInvoiceAction(String studentNo){
        enterTextIntoElement(SELECT_STUDENT_FIELD_IDENTIFIER, studentNo);
        clickElement(NEXT_BUTTON_IDENTIFIER);
        waitForElementToBeDisplayed(By.id("ANSWER.TTQ.MENSYS.1."), driver, 10);
    }