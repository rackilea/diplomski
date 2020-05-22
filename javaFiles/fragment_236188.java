Control control = your control
IControlContentAdapter controlContentAdapter = your control context adapter
String[] proposals = your proposals

SimpleContentProposalProvider proposalProvider = new SimpleContentProposalProvider(proposals);

proposalProvider.setFiltering(true);

ContentProposalAdapter adapter = new ContentProposalAdapter(control, controlContentAdapter, proposalProvider, null, null);

adapter.setPropagateKeys(true);
adapter.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);