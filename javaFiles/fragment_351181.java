for (int i = 0, c = LinkCollector.getInstance().getPackages()
                .size(); i < c; i++) {

            if (LinkCollector.getInstance().getPackages().get(i)
                    .getChildren().get(0).getSize() > 0) {
                DownloadController.getInstance().addAll(
                        LinkCollector.getInstance().convert(
                                LinkCollector.getInstance().getPackages()
                                        .get(i).getChildren(), true));
            }
        }