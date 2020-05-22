int count = 1;
for(CustomerAttempt customerAttemptTemp : customerAttemptList) {
    customerAttemptTemp.setIsActive("N");
    customerAttemptTemp.setIsActive(count++);
    customerAttemptService.update(customerAttemptTemp, _serviceContext);
}