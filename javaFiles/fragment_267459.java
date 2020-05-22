<td>
  <a name="{@name}"/>
  <xsl:choose>
    <xsl:when test="boolean($show.class)">
      <a href="{concat($class.href, '#', @name)}"><xsl:value-of select="@name"/></a>
    </xsl:when>
    <xsl:otherwise>
      <xsl:value-of select="@name"/>
    </xsl:otherwise>
  </xsl:choose>
</td>