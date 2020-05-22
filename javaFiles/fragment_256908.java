public static List<Report> oneReportPerMonthFilter(List<Report> reports) {
            Set<String> found = new HashSet<>();
            return reports.stream().filter(r -> found.add(getCreatedYearMonth(r))).collect(Collectors.toList());    
    }

    public static String getCreatedYearMonth(Report report) {
            //Or you can use SimpleDateFormat to extract Year & Month
            Calendar cal = Calendar.getInstance();
            cal.setTime(report.getCreated());
            return "" + cal.get(Calendar.YEAR) + cal.get(Calendar.MONTH);
        }
    }