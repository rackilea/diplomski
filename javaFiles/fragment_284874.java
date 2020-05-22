StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));

// Update the StringBuilder as per noraml
// Check valid as per normal

if (text.contains(".") && sb.contains(".")) {
  // already have decimal place
} else {
  // Business as usual...
}