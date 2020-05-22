OptGroupElement oge = Document.get().createOptGroupElement();   // not selectable
oge.setLabel( "B item 1" ):
oge.appendChild( ... /* Your selectable items */ )
...

// more opt groups here perhaps.
// ...

SelectElement se = listBox.getElement().cast();  // get listbox selection element
se.appendChild( oge ); // ...and add the option group(s).
...