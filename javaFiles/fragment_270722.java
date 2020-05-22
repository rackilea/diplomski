PersonRepository pRep = context.getBean(PersonRepository.class);
CompanyRepository cRep = context.getBean(CompanyRepository.class);
EmploymentRecordRepository emplRep = context.getBean(EmploymentRecordRepository.class);

...

// fetch a Company by Id and get its list of employees
Company comp = cRep.findOne(5L);
System.out.println("Found a company using findOne(5L), company= " + comp.getName());
System.out.println("People who work at " + comp.getName());
for (Person p : comp.getPersonList()) {
    System.out.println(p);
}