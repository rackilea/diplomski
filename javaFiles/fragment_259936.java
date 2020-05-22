private CheckBoxList List; 
        public E_JCheckListBox()
        {
            super("Select RFQs to Export");

            loglabel=new JLabel("Log:                                   .");
            List=new CheckBoxList();
//            CheckBoxList List = new CheckBoxList();
            JScrollPane scp=new JScrollPane();