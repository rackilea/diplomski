<xsl:template match="/"> 
  <xsl:text>Name, Age, Sex, Address&#xA;</xsl:text>
  <xsl:for-each select="//EmpDetails">
    <xsl:value-of select="concat(Name,',',Age,',',Sex,',&quot;',Address/AdderessLine1,'&quot;,&quot;',JobLocation,'&quot;&#xA;')"/>
  </xsl:for-each>
</xsl:template>