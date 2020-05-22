public static void main(String[] args) throws IOException {

    int pageCount = 1;
    List<Company> companies = new ArrayList<>();

    for (int i = 0; i < 10; i++) {

        System.out.println("get page n°" + pageCount);
        CompanyFilter companyFilter = getCompanyFilter("Startup", pageCount);
        pageCount++;
        System.out.println("digest     : " + companyFilter.getDigest());
        System.out.println("count      : " + companyFilter.getTotalCount());
        System.out.println("array size : " + companyFilter.getIds().size());
        System.out.println("page       : " + companyFilter.getpage());

        companies.addAll(getCompanies(companyFilter));

        if (companies.size() == 0) {
            break;
        } else {
            System.out.println("size     : " + companies.size());
        }
    }
}