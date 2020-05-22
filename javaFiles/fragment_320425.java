DescribeInstancesRequest dis = new DescribeInstancesRequest();   
dis.setInstanceIds(instancesList);
DescribeInstancesResult disresult = ec2.describeInstances(dis);
List<Reservation> list = disresult.getReservations();

System.out.println("-------------- status of instances -------------");
for (Reservation res : list) {
    List <Instance> instancelist = res.getInstances();

    for (Instance instance : instancelist) {
        System.out.println("Instance Status : " + instance.getState().getName());
        List <Tag> t1 = instance.getTags();
        for (Tag teg : t1) {
            System.out.println("Instance Name : "+ teg.getValue());
        }
    }   
    System.out.println("------------------------------------------------");
}