//initialize PageInfo with desired values
        PageInfo page_info = new PageInfo(1,10,4);
        List<PaymentTransactions> paymentTransactions = transactionsService
            .transactionsByDate(reconcile.getStart_date(), reconcile.getEnd_date(), merchant, terminal, page_info);  // pass in page_info

        ReconcilePaymentResponses pr = new ReconcilePaymentResponses();
        pr.setPage(page_info.getCurrentPage());
        pr.setPages_count(page_info.getPageCount());
        pr.setPer_page(page_info.getPerPage());
        pr.setTotal_count(String.valueOf(paymentTransactions.size()));

        for (int e = 0; e < paymentTransactions.size(); e++) {
            PaymentTransactions pt = paymentTransactions.get(e);

            ReconcilePaymentResponse obj = new ReconcilePaymentResponse();
            obj.setTransaction_type(pt.getType());
            pr.getPaymentResponse().add(obj);
        }

        return pr;