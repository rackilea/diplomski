<xsl:template match="ComponentDetails">
  <xsl:copy>
      <ComponentType ID="{ComponentType}">
          <xsl:apply-templates />
      </ComponentType>
  </xsl:copy>
</xsl:template>