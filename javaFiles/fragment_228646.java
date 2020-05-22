public void setUp() throws Exception { selenium = new DefaultSelenium("localhost", 4444, "*iexplore", "http://(some URL)"); selenium.start(); }


public void setUp() throws Exception { selenium = new DefaultSelenium("localhost", 4444, "*opera", "http://(some URL)"); selenium.start(); }

public void setUp() throws Exception { selenium = new DefaultSelenium("localhost", 4444, "*custom", "http://(some URL)"); selenium.start(); }