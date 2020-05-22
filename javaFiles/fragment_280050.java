while (selectAllDetails.next()) {
            String clientName = selectAllDetails.getString("Client Name");
            String providerName = selectAllDetails.getString("Provider Name");
            Double amountInvested = selectAllDetails.getDouble("Invest_Amount");
            //Update the table
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    Object[] row = {clientName, providerName, amountInvested};
                    model.addRow(row);
                }
            });
            //Get the total
            totalAmount = totalAmount + amountInvested;
        }
final Double totalAmountInvested = totalAmount; // and now use this one in the Inner