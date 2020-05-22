public Single<PayResponse> pay(PayRequest apiRequest) {

    return client.initiatePayment(apiRequest)
                .flatMap(initiatePaymentResponse -> {
                        System.out.println("first");
                        return client.confirmPayment(initiatePaymentResponse.getPaymentId();
                })
                .flatMap(confirmPaymentResponse -> {
                        System.out.println("second");
                        return doConfirmationLogic(confirmPaymentResponse);
                })
               .doOnSuccess(confirmationLogicResponse -> System.out.println("third"))
               .doOnError(ex -> {
                        ex.printStackTrace();
                        logError(ex);
                });
}