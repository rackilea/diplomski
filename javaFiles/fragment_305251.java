<application xmlns="http://research.sun.com/wadl/2006/10">
<resources base="http://localhost:9090/">
<resource path="images">
  <resource path="{imageId : [A-Za-z0-9_\-]+}">
    <param xmlns:xs="http://www.w3.org/2001/XMLSchema" name="imageId" style="template" type="xs:string"/>
    <method id="putImage" name="PUT">
      <request>
        <representation mediaType="image/*"/>
      </request>
      <response>
        <representation mediaType="*/*"/>
      </response>
    </method>
  </resource>
  <resource path="{imageId : [A-Za-z0-9_\-]+}{extension : (\.[A-Za-z]+)?}">
    <param xmlns:xs="http://www.w3.org/2001/XMLSchema" name="extension" style="template" type="xs:string"/>
    <param xmlns:xs="http://www.w3.org/2001/XMLSchema" name="imageId" style="template" type="xs:string"/>
    <method id="getImage" name="GET">
      <request>
        <param xmlns:xs="http://www.w3.org/2001/XMLSchema" name="mods" style="query" type="xs:string"/>
      </request>
      <response>
        <representation mediaType="image/*"/>
      </response>
    </method>
  </resource>
</resource>
</resources>
</application>