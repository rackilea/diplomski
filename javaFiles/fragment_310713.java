public void setTitle(String title) {
  this.title = title;
    if(label != null)
      appendChild(new Label(title));
    else
      lebel.setValue(title);
}