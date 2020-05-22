<xsl:template match="TagList">
  <xsl:element name="{@name}">
    <xsl:apply-templates/>
  </xsl:element>
</xsl:template>

<xsl:template match="Tag">
  <xsl:element name="{@name}">
    <xsl:value-of select="@value"/>
  </xsl:element>
</xsl:template>