@BindView(R.id.listviewResponse)
        ListView listViewResponse;
        @BindView(R.id.listviewOpen)
        ListView listViewOpen;
        @BindView(R.id.listviewDirect)
        ListView listViewDirect;

        private List<Response> responses = new ArrayList<>();
        private List<OpenOrder> open_orders = new ArrayList<>();
        private List<DirectOrder> direct_orders = new ArrayList<>();

        RequestListResponseAdapter adapterResponse;
        RequestListOpenAdapter adapterOpen;
        RequestListDirectAdapter adapterDirect;

        adapterResponse = new RequestListResponseAdapter(getContext(), responses);
        adapterOpen = new RequestListOpenAdapter(getContext(), open_orders, openType);
        adapterDirect = new RequestListDirectAdapter(getContext(), direct_orders);
        listViewResponse.setAdapter(adapterResponse);
        listViewDirect.setAdapter(adapterDirect);
        listViewOpen.setAdapter(adapterOpen);