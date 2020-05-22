MyClass implements Runnable {


     JTable m_jtable;

     public MyClass( JTable theTable ) { m_jtable = theTable; }

     public void run() { do things with m_jtable }
 }