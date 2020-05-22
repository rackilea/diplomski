Element person=document.createElement("Person");
person.setAttribute("ID", String.valueOf(i+1)); // to add attribute
Element pantsColor=doc.createElement("PantsColor");
Element shirtColor=doc.createElement("ShirtColor");
pantsColor.appendChild(doc.createTextNode(in));
person.appendChild(pantsColor);
person.appendChild(shirtColor);
root.appendChild(person);
...