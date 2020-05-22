@Override
@Transactional(readOnly = true)
public CompanyDetails getCompanyDetails(String companyShortCode) {
    System.out.println("companyShortCode = "+companyShortCode);
    CompanyDetails details = (CompanyDetails) sessionFactory.getCurrentSession().load(CompanyDetails.class, companyShortCode);
    details.getCompanyName(); //after this all attribute of CompanyDetails object will be set
    System.out.println("details = "+details);
    return details;
}
}