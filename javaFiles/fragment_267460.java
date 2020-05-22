<td>
  <a name="{@name}"/>
  <xsl:choose>
    <xsl:when test="boolean($show.class)">
      <a href="{concat($class.href, '#', @classname)}"><xsl:value-of select="@classname"/></a>
    </xsl:when>
    <xsl:otherwise>
      <xsl:value-of select="@classname"/>
    </xsl:otherwise>
  </xsl:choose>
</td>