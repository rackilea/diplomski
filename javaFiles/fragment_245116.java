return parts.stream().map(part ->
    ExcelReportForm.builder().facility(form.getFacility())
        .month(form.getMonth())
        .year(form.getYear())
        .partNumber(part)
        .build()
);