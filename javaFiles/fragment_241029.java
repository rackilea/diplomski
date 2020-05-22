<xsd:attribute name="url-expression" type="xsd:string" use="optional">
        <xsd:annotation>
            <xsd:documentation>
                <![CDATA[
SpEL Expression resolving to a URL to which the requests should be sent. The resolved
value may include {placeholders} for further evaluation against uri-variables.
                ]]></xsd:documentation>
        </xsd:annotation>
    </xsd:attribute>