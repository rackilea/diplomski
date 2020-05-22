private void initialiseTabHost() {
        String id = getIntent().getExtras().getString("id");
        Bundle args = new Bundle();
        args.putString("id", id);
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup();
        TabInfo tabInfo = null;
        RelatorioPontos.addTab(this, this.mTabHost, this.mTabHost.newTabSpec("Dados").setIndicator("Dados"),
                (tabInfo = new TabInfo("Dados", DadosPonto.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        RelatorioPontos.addTab(this, this.mTabHost, this.mTabHost.newTabSpec("Analises").setIndicator("Analises"),
                (tabInfo = new TabInfo("Analises", AnalisesPonto.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        RelatorioPontos.addTab(this, this.mTabHost, this.mTabHost.newTabSpec("Multimidia").setIndicator("Multimidia"),
                (tabInfo = new TabInfo("Multimidia", ArquivosMultimidia.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
    }