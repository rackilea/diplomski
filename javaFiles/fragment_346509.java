Toolbar t = new Toolbar();
f.setToolBar(t);
Command news = new Command("News", myIcon) {

    @Override
    public void actionPerformed(ActionEvent evt) {

    }
};
news.putClientProperty("uiid", "BackCommand");
f.setBackCommand(news);
t.addCommandToLeftBar(news);
t.setTitle("My Form");