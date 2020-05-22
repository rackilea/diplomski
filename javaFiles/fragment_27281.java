@RequestMapping(value="{userid}", method = RequestMethod.GET)
public @ResponseBody List<IterationInfo> getIterationInfoInJSON(@PathVariable int userid) 
{

Configuration con = new Configuration();
con.configure("hibernate.cfg.xml");
SessionFactory SF = con.buildSessionFactory();
Session session= SF.openSession();
Transaction TR = session.beginTransaction();
Query query=session.createQuery("from IterationInfo");
List<IterationInfo> list=query.list();
for(IterationInfo iterationinfo1 : list)
{
    System.out.println("Iteration id"+iterationinfo1.getIterationid());
    System.out.println(iterationinfo1.getIterationname());
    System.out.println(iterationinfo1.getProjectid());
    System.out.println(iterationinfo1.getIterationenddate());
    System.out.println(iterationinfo1.getIterationstartdate());
    iterationinfo1.setIterationid(iterationinfo1.getIterationid());
    iterationinfo1.setIterationname(iterationinfo1.getIterationname());
    iterationinfo1.setProjectid(iterationinfo1.getProjectid());
    iterationinfo1.setIterationenddate(iterationinfo1.getIterationenddate());
    iterationinfo1.setIterationstartdate(iterationinfo1.getIterationstartdate());
}
TR.commit();
session.close();
SF.close();

return list;
}