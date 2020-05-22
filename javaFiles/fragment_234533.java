public String createInvoice() throws CustomerNotEnrolledException {

    if ((this.courseList == null) || (this.courseList.isEmpty())) {
        throw new CustomerNotEnrolledException("Customer does not have any course");
    }

    // rest of your method goes here
}