public class OListPanel extends ComplexPanel { 
final OListElement ol = Document.get().createOLElement();

public OListPanel() {
    setElement(ol);
}

public void add(Widget w) {
    LIElement li = Document.get().createLIElement();
    ol.appendChild(li);
    add(w, (Element)li.cast());
}

public void insert(Widget w, int beforeIndex) {
    checkIndexBoundsForInsertion(beforeIndex);

    LIElement li = Document.get().createLIElement();
    ol.insertBefore(li, ol.getChild(beforeIndex));
    insert(w, (Element)li.cast(), beforeIndex, false);
}

public boolean remove(Widget w) {
    Element li = DOM.getParent(w.getElement());
    boolean removed = super.remove(w);
    if (removed) {
        ol.removeChild(li);
    }
    return removed;
}
}