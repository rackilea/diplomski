public void mouseClicked(MouseEvent e)
        {
            Element ele = doc.getCharacterElement(chatbox.viewToModel(e.getPoint()));
            AttributeSet as = ele.getAttributes();
            ChatLinkListener fla = (ChatLinkListener)as.getAttribute("linkact");
            if(fla != null)
            {
                fla.execute();
            }
        }