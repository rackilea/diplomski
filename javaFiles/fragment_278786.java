Query q = em.createNativeQuery("select
    sum(case when Status_2 = 'Allocated' then 1 else 0 end) as Allocated,
    sum(case when Status_2 = 'Bench' then 1 else 0 end) as Bench
    from userbean where Organizational_Unit = 'SIDG Java'
    union   
select
    sum(case when Status_2 = 'Allocated' then 1 else 0 end) as Allocated,
    sum(case when Status_2 = 'Bench' then 1 else 0 end) as Bench
    from userbean where Organizational_Unit = 'SIDG Microsoft'");

List<Object[]> result= q.getResultList();

// for each line retrieved
for (Object[] currentLine : result) {
    System.out.println("Allocated=" + currentLine[0]
                    + ", Bench=" + currentLine[1] ;
}