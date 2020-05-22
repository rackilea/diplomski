String qString = "SELECT d FROM  " + InvoiceSeller.class.getSimpleName() + " d "
            + " INNER JOIN "+ InvoiceSellerContact.class.getSimpleName() + " sc "
            + " INNER JOIN "+ Contact.class.getSimpleName() + " c "
            + " INNER JOIN " + ActiveRegisterMaster.class.getSimpleName() + " a "
            + " WHERE a.tableName = :tablename AND d.invoiceDebtor.code = :debtorCode "
            + " AND c.email = :email AND d.status = :status";
            + " AND c.email = :email AND d.status = :status";