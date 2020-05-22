BasicEditField bef = new BasicEditField("BBDeveloper","")
    {
        public int getPreferredHeight() 
        {
            return 30;
        }

        public int getPreferredWidth() 
        {
            return 100;
        }

        public void layout(int width, int height) 
        {
            setExtent(getPreferredWidth(), getPreferredHeight());
            super.layout(getPreferredWidth(), getPreferredHeight());
        }
    };