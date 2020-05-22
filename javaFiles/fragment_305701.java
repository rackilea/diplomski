<ee:transform doc:name="Transform Message" doc:id="ad2a1dd7-0973-4854-b44c-bdfe8eb54778">

            <ee:set-variable variableName="docHashMap"><![CDATA[%dw 2.0
    import * from dw::core::Binaries
    output application/java
    ---

    vars.docHashMap + ({
      "Attachment_Document_Type": vars.factIntakeDocPayload.documentId,
      "Attachement_Content_Type": vars.documentMetadata.contentType,
      "Attachment_Content": toBase64(payload)
    })]]></ee:set-variable>

    </ee:transform>