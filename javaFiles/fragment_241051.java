@Override
protected void beforeMain(Form f) {

    final Container cont = new Container(new BorderLayout());
    String url = "https://www.google.com";

    WebBrowser web = new WebBrowser() {

        @Override
        public void onLoad(String url) {

            this.setShouldCalcPreferredSize(true);

            Display.getInstance().callSerially(new Runnable() {

                public void run() {

                    cont.revalidate();

                }
            });
        }

    };

    web.setURL(url);
    cont.addComponent(BorderLayout.CENTER, web);
    f.setLayout(new BorderLayout());
    f.addComponent(BorderLayout.CENTER, cont);
    f.revalidate();
}