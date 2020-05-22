//Write the results to a file.          
        //Add an Export button
        Button btnExport = new Button("Export Details");
        btnExport.setWidth("105px");
        btnExport.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {

                java.sql.Date sqlStartDate = dateBoxStart.getValue() == null ? null : new java.sql.Date(dateBoxStart.getValue().getTime());
                java.sql.Date sqlEndDate = dateBoxEnd.getValue() == null ? null : new java.sql.Date(dateBoxEnd.getValue().getTime());

                AsyncCallback<String> callback = new PrintPackSummaryHandler<String>(PackSummaryView.this);
                rpc.printPackSummary(scoutGroupId, sqlStartDate, sqlEndDate, callback); 

            }
        });
        horizontalDatesPanel.add(btnExport);