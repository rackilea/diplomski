grid.setDataProvider((sortorder, offset, limit) -> {

        try {
            limit=20;
            return billingClient.getInvoiceListByCriteria(criteria, (long) offset, (long) limit).stream();
        } catch (Exception e) {
            logger.error("Exception while getInvoiceListByCriteria", e);
            return null;
        }
    }, () -> {

        try {
            totalInvoices = billingClient.getCountInvoiceListByCriteria(criteria).longValue();
            Integer count = totalInvoices.intValue();
            if (count == 0)
                Notification.show("No Invoices found.", Notification.Type.HUMANIZED_MESSAGE);
            return count;
        } catch (Exception e) {
            logger.error("Error occured while getting count calling getCountInvoiceListByCriteria", e);
            Notification.show("Error while getting count", Notification.Type.ERROR_MESSAGE);
            return null;
        }

    });