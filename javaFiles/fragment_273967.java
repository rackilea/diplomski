<xsl:template match="*">
<xsl:element name="{local-name()}">
  <xsl:for-each select="@*">
    <xsl:attribute name="{local-name()}">
      <xsl:value-of select="."/>
    </xsl:attribute>
  </xsl:for-each>
  <xsl:apply-templates/>
</xsl:element>
</xsl:template>