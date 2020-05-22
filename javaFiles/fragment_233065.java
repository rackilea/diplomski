System.out.println(
        Company.getInstance().getConsultantLeaders().size() + // leaders
        Company.getInstance().getDeveloperWorkers().size() +
        Company.getInstance().getConsultantLeaders().size() +//this one must be workers 
        Company.getInstance().getDeveloperLeaders().size() +
        Company.getInstance().getProjectLeaders().size());