@Override
public Component getComponentAfter(Container aContainer, Component aComponent) {
    System.out.println("after " + aComponent);
    Component last = lastComponentInCurrentTab();
    if (aComponent == last) {
      // we reached the end. Go to the next tab!
      currentTab = currentTab + 1;
      Component fc = firstComponentInCurrentTab();
      activateTab(currentTab);
      return fc;

    }
    return super.getComponentAfter(aContainer, aComponent);
}