public static void main(String args[]){
       TextMessageReceive c = new TextMessageReceive();

            // turn on the enhanced debugger
            XMPPConnection.DEBUG_ENABLED = true;
            // Enter your login information here
            c.login("yuvi", "yuvi");
            c.disconnect();
            /*
             * Displays the users list
             */
}