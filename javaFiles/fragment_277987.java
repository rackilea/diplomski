List<AllCustomerHist> cust = allCustomerHistService.findBU(id);
List<String> bu = new ArrayList<String>(cust.size());

        for (i=0; i<cust.size(); i++){
            System.out.println("iteration = "+i);
            AllCustomerHist aCust = cust.get(i);
            bu.add(aCust.getSrctable());

        }
//here your bu list should be ready to be used.....