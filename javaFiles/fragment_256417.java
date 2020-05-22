...
...
@Test
    public void test1() {
        Future data = a.startFlow(new Initiator("Owner1", "1234567", "Description", "c1", Instant.now().toString(), Instant.MAX.toString(), b.getInfo().getLegalIdentities().get(0).getName().toString()));
        network.runNetwork();
        try {
            System.out.println(data.get());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        QueryCriteria.VaultQueryCriteria criteria1 = new QueryCriteria.VaultQueryCriteria(Vault.StateStatus.CONSUMED);
        Vault.Page<AnchorState> results1 = a.getServices().getVaultService().queryBy(AnchorState.class, criteria1);
        System.out.println("--------------------- "+ results1.getStates().size());

        QueryCriteria.VaultQueryCriteria criteria2 = new QueryCriteria.VaultQueryCriteria(Vault.StateStatus.ALL);
        Vault.Page<AnchorState> results2 = a.getServices().getVaultService().queryBy(AnchorState.class, criteria2);
        System.out.println("--------------------- "+ results2.getStates().size());

        QueryCriteria.VaultQueryCriteria criteria3 = new QueryCriteria.VaultQueryCriteria(Vault.StateStatus.CONSUMED);
        Vault.Page<AnchorState> results3 = b.getServices().getVaultService().queryBy(AnchorState.class, criteria3);
        System.out.println("--------------------- "+ results3.getStates().size());

        QueryCriteria.VaultQueryCriteria criteria4 = new QueryCriteria.VaultQueryCriteria(Vault.StateStatus.ALL);
        Vault.Page<AnchorState> results4 = b.getServices().getVaultService().queryBy(AnchorState.class, criteria4);
        System.out.println("--------------------- "+ results4.getStates().size());
    }