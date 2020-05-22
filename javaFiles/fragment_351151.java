171   protected void More ...installComponents() {
172       optionPane.add(createMessageArea());
173 
174       Container separator = createSeparator();
175       if (separator != null) {
176           optionPane.add(separator);
177       }
178       optionPane.add(createButtonArea());
179       optionPane.applyComponentOrientation(optionPane.getComponentOrientation());
180   }