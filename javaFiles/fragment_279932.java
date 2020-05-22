public AdminToken(VirtualServer server)
{
    this.server = server;
    getContentPane().setLayout(null);
    setupGUI();
   setLayout(new GridLayout(5,1));
}