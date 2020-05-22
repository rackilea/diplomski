public class MyFrame extends javax.swing.JFrame {
    private final EventList<BibleVersion> bibleVersions;
    private final SeparatorList<BibleVersion> versionsByLang;
    private boolean[] enabledFlags;

    public MyFrame(){
        bibleVersions = new BasicEventList<>();
        bibleVersions.add(new BibleVersion("CEI2008", "Testo della Conferenza Episcopale Italiana", "2008", "Italian"));
        bibleVersions.add(new BibleVersion("LUZZI", "Diodati Nuova Riveduta - Luzzi", "1927", "Italian"));
        bibleVersions.add(new BibleVersion("NVBSE", "Nova Vulgata - Bibliorum Sacrorum Editio", "1979", "Latin"));
        bibleVersions.add(new BibleVersion("NABRE", "New American Bible - Revised Edition", "2011", "English"));
        bibleVersions.add(new BibleVersion("KJV", "King James Version", "1611", "English"));
        versionsByLang = new SeparatorList<>(bibleVersions, new VersionComparator(),1, 1000);
        int listLength = versionsByLang.size();
        enabledFlags = new boolean[listLength];

        ListIterator itr = versionsByLang.listIterator();
        while(itr.hasNext()){
            enabledFlags[itr.nextIndex()] = !(itr.next().getClass().getSimpleName().equals("GroupSeparator"));
        }
        jList = new javax.swing.JList();
        jList.setModel(new DefaultEventListModel<>(versionsByLang));
        jList.setCellRenderer(new VersionCellRenderer());
        jList.setSelectionModel(new DisabledItemSelectionModel());
        ListSelectionModel listSelectionModel = jList.getSelectionModel();
        listSelectionModel.addListSelectionListener(new SharedListSelectionHandler());

    }

    public static class BibleVersion {
        private String abbrev;
        private String fullname;
        private String year;
        private String lang;

        public BibleVersion(String abbrev, String fullname, String year, String lang) {
            this.abbrev = abbrev;
            this.fullname = fullname;
            this.year = year;
            this.lang = lang;
        }        

        public String getAbbrev() {
            return abbrev;
        }

        public void setAbbrev(String abbrev) {
            this.abbrev = abbrev;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getLang() {
            return lang;
        }

        public void setLang(String lang) {
            this.lang = lang;
        }

        @Override
        public String toString() {
            return this.getAbbrev() + " — " + this.getFullname() + " (" + this.getYear() + ")"; //To change body of generated methods, choose Tools | Templates.
        }                

    }

    private static class VersionComparator implements Comparator<BibleVersion> {

        @Override
        public int compare(BibleVersion o1, BibleVersion o2) {
            return o1.getLang().compareTo(o2.getLang());
        }            

    }

    private static class VersionCellRenderer extends DefaultListCellRenderer{

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (value instanceof SeparatorList.Separator) {
                SeparatorList.Separator separator = (SeparatorList.Separator) value;
                BibleVersion bibleversion = (BibleVersion)separator.getGroup().get(0);
                String lbl = "-- " + bibleversion.getLang() + " --";
                label.setText(lbl);
                label.setFont(label.getFont().deriveFont(Font.BOLD));
                label.setBackground(Color.decode("#004400"));
                label.setBorder(BorderFactory.createEmptyBorder(0,5,0,0));
                label.setEnabled(false);
            } else {
                label.setFont(label.getFont().deriveFont(Font.PLAIN));
                label.setBorder(BorderFactory.createEmptyBorder(0,15,0,0));
            }

            return label;
        }
    }

private class DisabledItemSelectionModel extends DefaultListSelectionModel {

    private static final long serialVersionUID = 1L;

    @Override
    public void setSelectionInterval(int index0, int index1) {
        if(index0 < index1){
            for (int i = index0; i <= index1; i++){
                if(enabledFlags[i]){
                    super.addSelectionInterval(i, i);
                }
            }
        }
        else if(index1 < index0){
            for (int i = index1; i <= index0; i++){
                if(enabledFlags[i]){
                    super.addSelectionInterval(i, i);
                }
            }
        }
        else if(index0 == index1){
            if(enabledFlags[index0]){ super.setSelectionInterval(index0,index0); }
        }
    }

    @Override
    public void addSelectionInterval(int index0, int index1) {
        if(index0 < index1){
            for (int i = index0; i <= index1; i++){
                if(enabledFlags[i]){
                    super.addSelectionInterval(i, i);
                }
            }
        }
        else if(index1 < index0){
            for (int i = index1; i <= index0; i++){
                if(enabledFlags[i]){
                    super.addSelectionInterval(i, i);
                }
            }
        }
        else if(index0 == index1){
            if(enabledFlags[index0]){ super.addSelectionInterval(index0,index0); }
        }
    }        

}

private class SharedListSelectionHandler implements ListSelectionListener {
    @Override
    public void valueChanged(ListSelectionEvent e) {
        ListSelectionModel lsm = (ListSelectionModel)e.getSource();
        StringBuilder output = new StringBuilder();
        int firstIndex = e.getFirstIndex();
        int lastIndex = e.getLastIndex();
        boolean isAdjusting = e.getValueIsAdjusting();
        output.append("Event for indexes ");
        output.append(firstIndex);
        output.append(" - ");
        output.append(lastIndex);
        output.append("; isAdjusting is ");
        output.append(isAdjusting);
        output.append("; selected indexes:");

        if (lsm.isSelectionEmpty()) {
            output.append(" <none>");
        } else {
            // Find out which indexes are selected.
            int minIndex = lsm.getMinSelectionIndex();
            int maxIndex = lsm.getMaxSelectionIndex();
            for (int i = minIndex; i <= maxIndex; i++) {
                if (lsm.isSelectedIndex(i)) {
                    output.append(" ");
                    output.append(i);
                }
            }
        }
        output.append(System.getProperty("line.separator"));
        System.out.println(output.toString());
    }
}


}