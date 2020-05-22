<xsl:template match="Group" >
  <xsl:call-template name="identity" />;
  <xsl:if test="@id = $groupId">
    <group id="{$newGroupId}">
      <xsl:apply-templates select="@*[name() != 'id']|node()"/>
    </group>
  </xsl:if>
</xsl:template>