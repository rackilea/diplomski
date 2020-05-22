Notify.create()
      .title(text)
      .text(title)
      .position(Pos.TOP_RIGHT)
      .onAction( new ActionHandler<Notify>() {
            @Override
            public void handle(Notify value) {
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    try {
                        Desktop.getDesktop().browse(new URI(targetUrl));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (URISyntaxException e) {
                        e.printStackTrace();
                    }
                }
            }
      })
      .hideAfter(5000)
      .shake(250, 5)
      .darkStyle()      // There are two default themes darkStyle() and default.
      .showConfirm();   // You can use warnings and error as well.