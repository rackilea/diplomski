// ------------------------------CUSTOM TAGS-----------------------------

    if(getChat_id()!=null)
    {
        buf.append(" chat_id=\"").append(StringUtils.escapeForXML(getChat_id())).append("\"");

    }
    if(getCustom_packet()!=null)
    {
        buf.append(" custom_packet=\"").append(StringUtils.escapeForXML(getCustom_packet())).append("\"");

    }
    if(getUser_id()!=null)
    {
        buf.append(" user_id=\"").append(StringUtils.escapeForXML(getUser_id())).append("\"");

    }

    if(getManager_id()!=null)
    {
        buf.append(" manager_id=\"").append(StringUtils.escapeForXML(getManager_id())).append("\"");

    }
    if(getTime_stamp()!=null)
    {
        buf.append(" time_stamp=\"").append(StringUtils.escapeForXML(getTime_stamp())).append("\"");

    }
    if(getWebsite_id()!=null)
    {
        buf.append(" website_id=\"").append(StringUtils.escapeForXML(getWebsite_id())).append("\"");

    }
    if(getVisitor_name()!=null)
    {
        buf.append(" visitor_name=\"").append(StringUtils.escapeForXML(getVisitor_name())).append("\"");

    }
    if(getEnd_time()!=null)
    {
        buf.append(" end_time=\"").append(StringUtils.escapeForXML(getEnd_time())).append("\"");

    }

    //------------------------------------------------------------------------------------