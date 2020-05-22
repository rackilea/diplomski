for(int i=0;i<2;i++) {                     
    int apart = i+1;    
    String response2 = getDataConnection(clientRes, apart);
    pr.println("aparment " + apart +"  "  + response2);
}
pr.flush();