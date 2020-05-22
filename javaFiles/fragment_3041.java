public void SendInstrumentSymbols() {
        // Get the current page.
        String page = ServerContextFactory.get().getContextPath() + "/faces/Instruments.xhtml";
        // Create a new AttributeScriptSessionFilter which will look for an attribute on the ScriptSession
        ScriptSessionFilter attributeFilter = new AttributeScriptSessionFilter(SCRIPT_SESSION_ATTR);
        // Update the page, filters ScriptSessions using attributeFilter.  If the SCRIPT_SESSION_ATTR
        // has not been set on the ScriptSession the page in question will not receive updates.
        Collection sessions = ServerContextFactory.get().getScriptSessionsByPage(page);
        Browser.withPageFiltered(page, attributeFilter, new Runnable()
        {
            <b>@Override
            public void run()
            {
                // Creates a new Person bean.
                List<Instrument> InstrumentList = new ArrayList<Instrument>();
                InstrumentList = findInstrumentSymbols() ;

        /*This seems to be the tricky part - Sending the List<Instrument> to the server end.*/

                // Creates a multi-dimensional array, containing a row and the rows column data.
                String[][] data = {
                    {InstrumentList.get(0).getSymbolName().toString(), InstrumentList.get(0).getName().toString(), String.valueOf(InstrumentList.get(0).getQuantity()), InstrumentList.get(0).getPrice().toString(), String.valueOf(InstrumentList.get(0).getMarketMakingLimit()),String.valueOf(InstrumentList.get(0).isBuyOrderMarketMakingOn()),String.valueOf(InstrumentList.get(0).isSellOrderMarketMakingOn())}};
                // Call DWR's util which adds rows into a table.  instrumentTable is the id of the tbody and 
                // data contains the row/column data.  
                Util.addRows("instrumentTable", data);
            }
        }</b>);
    }