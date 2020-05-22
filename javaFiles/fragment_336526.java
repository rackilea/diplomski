<xp:selectItems>
        <xp:this.value><![CDATA[#{try{
return rowData.getColumnValue("DialogChoices");
           }catch(e){// do something }]]>
        </xp:this.value>
    </xp:selectItems>