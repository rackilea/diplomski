<xp:this.resources>
        <xp:bundle var="application">
            <xp:this.src><![CDATA[#{javascript:if(context.getLocale()=="en_US")
return "/application.properties";
else
return "/application_de.properties";}]]></xp:this.src>
        </xp:bundle>
    </xp:this.resources>