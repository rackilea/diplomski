public Account (Object[] fromStoredProcedure) {
        super();
        this.name           = (String)fromStoredProcedure[0];
        this.address_1      = (String)fromStoredProcedure[1];
        this.address_2      = (String)fromStoredProcedure[2];           
    }