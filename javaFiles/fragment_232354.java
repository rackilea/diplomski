public void onClick(ClickEvent event)
        {
            if(m_legendHolder.isVisible())
            {
                m_legendHolder.hide();
                hideScrollableDiv();
            }
            else
            {
                showScrollableDiv();
                m_legendHolder.show();
            }
        }