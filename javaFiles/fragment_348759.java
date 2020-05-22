@Override
@Transactional(readOnly = true)
public CompanyDetails getCompanyDetails(String companyShortCode) {
    System.out.println("companyShortCode = "+companyShortCode);
    CompanyDetails details = (CompanyDetails) sessionFactory.getCurrentSession().get(CompanyDetails.class, companyShortCode);
    System.out.println("details = "+details);
    return details;
}
}