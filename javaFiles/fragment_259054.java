package com.pasquier.IDAO.WS;

import lotus.domino.Session;

public class LogWebService implements ILogWebService {

    private Session session;
    private LogWSDTO logDTO = null; 

    public LogWebService() {
        System.out.println("LogWebService: Default Constructor called!");
    }

    public void setLog(LogWSDTO log) {
        this.logDTO = log;      
    }

    public LogWebService(LogWSDTO log) {
        this.logDTO = log;
        System.out.println("~~~ LogWebService.constructor!!!");
    }

    public void notesMain() {
        // TODO Auto-generated method stub
        System.out.println("~~~ LogWebService.notesmain called!!!");
        this.logDTO.log();

    }
}