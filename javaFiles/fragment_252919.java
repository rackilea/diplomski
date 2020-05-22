TABhs = new CopyOnWriteArraySet(TABhs);
    for(Iterator <PrintWriter> it=TABhs.iterator();it.hasNext();)
    { 
          PrintWriter ot=it.next();
          ot.println("tableupdate#"+tables+"#"+kotno+"#processing");
          ot.flush();
          JOptionPane.showMessageDialog(rootPane, "<html><body>Table Kot Status Changed to <b>Processing</b></body></html>");
    }