while (rs.next())
            {
                Element child1 = doc.createElement("Company");
                child1.setAttributeNS(xlink, "xlink:type", rs.getString (1));
                child1.setAttributeNS(xlink, "xlink:show", "  ");
                child.appendChild(child1);   
            }