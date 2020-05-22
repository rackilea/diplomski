<jxb:bindings schemaLocation="schema.xsd">
    <jxb:bindings node="/xs:schema/xs:complexType[@name='MyItemType']">
        <ci:code>
            @Override
            public int hashCode() { return guid == null? 0 : guid.hashCode();}
        </ci:code>
    </jxb:bindings>
</jxb:bindings>