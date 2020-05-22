@Override
    protected void onUpdate(AjaxRequestTarget paramAjaxRequestTarget) {
        endDateValue = endDate.getDate();
        exportButtonVisibility();
        paramAjaxRequestTarget.add(exportButton); // Add this line
    }