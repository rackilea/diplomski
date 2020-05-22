FlowPanel panel = new FlowPanel();
panel.setWidth("100%");

cancel = new Button("Cancel");
cancel.getElement().getStyle().setFloat(Float.RIGHT);
next = new Button("Next");
next.getElement().getStyle().setFloat(Float.RIGHT);
back = new Button("Back");
back.getElement().getStyle().setFloat(Float.RIGHT);

panel.add(back);
panel.add(nextBtn);
panel.add(cancel);