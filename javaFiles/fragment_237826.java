class ChatLinkListener extends AbstractAction
    {
        private String textLink;

        ChatLinkListener(String textLink)
        {
            this.textLink = textLink;
        }

        protected void execute()
        {
            if("accept".equals(url))
            {
                //execute code
            }
            else if("decline".equals(url))
            {
                //execute code
            }
        }

        public void actionPerformed(ActionEvent e)
        {
            execute();
        }
    }