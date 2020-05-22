// Detach new child.
child.removeFromParent();

// Logical attach.
getChildren().add(child);

// Physical attach.
DOM.appendChild(container, child.getElement());

// Adopt.
adopt(child);