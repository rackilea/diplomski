<xsl:choose>
  <xsl:when test="string-length(Lkup_CODE) &gt; 11">
    <xsl:value-of select="concat(substring($Lkup_CODE, 1, 8), substring(Lkup_CODE, 10, 3))"/>
  </xsl:when>
  <xsl:when test="string-length(Lkup_CODE) = 11">
    <xsl:value-of select="Lkup_CODE"/>
  </xsl:when>
  <xsl:otherwise>
    <xsl:value-of select="Lkup_CODE"/>
  </xsl:otherwise>
</xsl:choose>