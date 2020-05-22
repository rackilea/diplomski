@Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ReportListDto that = (ReportListDto) o;

        return reports != null ? reports.equals(that.reports) : that.reports == null;

    }