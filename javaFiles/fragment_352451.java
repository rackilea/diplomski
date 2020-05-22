// 1
Element details = doc.getRootElement();
// 2
Element rowset = details.getChild("ROWSET");
// 3
for (Element row: rowset.getChildren()) {
    Element r = row.detach();
    details.appendChild(r);
}
// 4
details.removeChild(rowset);