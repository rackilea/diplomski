for (Reservation reservation : result.getReservations()) {
    for (Instance instance : reservation.getInstances()) {
        System.out.println("Instance id:" + instance.getInstanceId());

        if (instance.getTags() != null) {
            for (Tag tag : instance.getTags()) {
                System.out.println(String.format(
                    "%s: %s", 
                    tag.getKey(), 
                    tag.getValue()
                ));
            }
        }
    }
}