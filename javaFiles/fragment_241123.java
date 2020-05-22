Hyperlink eventStatusLink = new Hyperlink(moveToMainApplication, "");

    eventStatusLink.addClickHandler(new ClickHandler() 
    {
        @Override
        public void onClick(ClickEvent event) {
            String eventStatusUrl = "/company/MainAppServlet?action=Launch&ID="+ IDFromGWT";
            // info("eventStatusUrl:"+eventStatusUrl);
            //Window.Location.assign(eventStatusUrl);
          redirectToOtherModule(eventStatusUrl);

        }
    });