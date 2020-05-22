TabPaneBuilder.create()
.tabs(
    TabBuilder.create()
        .text("Main")
        .closable(false)
        .build(),

//New code coming through

    previewTab = TabBuilder.create()
        .text("Preview")
        .content(createPreviewSplitMenu())
        .closable(false)

        .onSelectionChanged(new EventHandler<Event>() {
        public void handle(Event evt) {
          if (previewTab.isSelected()) {
            //code to update the tab
          }
        }
      })

      .build()
    )
.build()