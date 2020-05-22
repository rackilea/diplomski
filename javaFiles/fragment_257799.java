tx.begin();
IndustryCode ic1 = new IndustryCode("Reliance");
IndustryCode ic2 = new IndustryCode("TaTa");
TechCode tc1 = new TechCode("java");
TechCode tc2 = new TechCode("cpp");
CarrierCodes cc1 = new CarrierCodes(tc1, ic1);
CarrierCodes cc2 = new CarrierCodes(tc1, ic2);
CarrierCodes cc3 = new CarrierCodes(tc2, ic1);
Register r1 = new Register(12345L, cc1);
Register r2 = new Register(78913L, cc2);

em.persist(ic1);
em.persist(ic2);
em.persist(tc1);
em.persist(tc2);
em.persist(cc1);
em.persist(cc2);
em.persist(cc3);
em.persist(r1);
em.persist(r2);
tx.commit();

em.clear();
List<Register> rs = em.createQuery("select r from Register r left outer join fetch r.carrierCodes cc where cc.techCode.techName = 'java'", Register.class).getResultList();
rs.stream().forEach(r->System.out.println(r.getMobileNumber() + " " + r.getCarrierCodes().getTechCode().getTechName()));

List<Register> rs2 = em.createQuery("select r from Register r left outer join fetch r.carrierCodes cc where cc.industryCode.industryName = 'TaTa'", Register.class).getResultList();
rs2.stream().forEach(r->System.out.println(r.getMobileNumber() + " " + r.getCarrierCodes().getIndustryCode().getIndustryName()));