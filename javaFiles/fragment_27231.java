View rootView = inflater.inflate(R.layout.fragment_offer_detail_item, container, false);

 listView = (ListView)view.findViewById(R.id.listView);
    ussdlist = new ArrayList<>();
    ussdlist.add(new ussdz("*#44336#","Software Version Info"));
    ussdlist.add(new ussdz("*#44336#","Software Version Info"));
    ussdlist.add(new ussdz("*#44336#","Software Version Info"));
    ussdlist.add(new ussdz("*#44336#","Software Version Info"));
    ussdlist.add(new ussdz("*#44336#","Software Version Info"));
    ussdlist.add(new ussdz("*#44336#","Software Version Info"));
    ussdlist.add(new ussdz("*#44336#","Software Version Info"));
    ussdlist.add(new ussdz("*#44336#","Software Version Info"));
    ussd = new ussdadaper(getActivity(),ussdlist);
    listView .setAdapter(ussd);   //you should setthe adapter to the listview
        return rootView;