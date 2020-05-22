<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="root">
    <xsl:variable name="href" select="substring-before(substring-after(text(), 'href=&quot;'), '&quot;')" />
    <xsl:variable name="path" select="substring-before(substring-after(text(), 'path=&quot;'), '&quot;')" />
    <a href="{$href}"><xsl:value-of select="$path" /></a>
  </xsl:template>
</xsl:stylesheet>