this.addListener(SWT.MouseExit, new Listener() {
        @Override
        public void handleEvent(Event event) {
            for (Control control : ParentClass.this.getChildren()) {
                if (control == event.item)
                    return;
            }
            // handler logic goes here
        }           
    });