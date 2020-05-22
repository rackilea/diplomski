// Add THIRD child element for CData 
    Element elementOrderContent = doc.createElement("orderContent");    
    StringBuffer orderContent = new StringBuffer();
    // Note: Removed the <![CDATA[ ]]> from this string concat
    orderContent.append("<center><table> <tr><td class=\"one width190\" align=\"left\" valign=\"top\">");
    orderContent.append("<span style=\" font-family: Arial, Helvetica, sans-serif; font-size: 12pt; color: #002469;\">");
    orderContent.append("Product:</span>&nbsp;&nbsp;</td><tr><td class=\"one\" align=\"left\" valign=\"top\"><span style=\" font-family: Arial, Helvetica, sans-serif; font-size: 12pt; color: #002469;\">");       
    orderContent.append("<strong>Product title</strong></span></td></tr> </table></center>");
    logger.info("The orderContent Element in XML : "+orderContent.toString());
    // HERE IS THE UPDATED LINE
    Text orderContentText = doc.createCDATASection(orderContent.toString());    
    logger.debug("Converted Text for Order Content is: "+orderContentText);
    elementOrderContent.appendChild(orderContentText);

    elementOrder.appendChild(elementOrderContent); //Add third Order Child: OrderContent