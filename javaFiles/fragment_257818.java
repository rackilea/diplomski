PseudoClass centered = PseudoClass.getPseudoClass("centered");

// activate pseudoclass
textArea.pseudoClassStateChanged(centered, true);

// deactivate pseudoclass
textArea.pseudoClassStateChanged(centered, false);